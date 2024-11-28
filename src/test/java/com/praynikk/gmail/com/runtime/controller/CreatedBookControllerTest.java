package com.praynikk.gmail.com.runtime.controller;

import com.praynikk.gmail.com.runtime.AppInit;
import com.praynikk.gmail.com.runtime.model.CreatedBook;
import com.praynikk.gmail.com.runtime.request.CreatedBookCreate;
import com.praynikk.gmail.com.runtime.request.CreatedBookFilter;
import com.praynikk.gmail.com.runtime.request.CreatedBookUpdate;
import com.praynikk.gmail.com.runtime.request.LoginRequest;
import com.praynikk.gmail.com.runtime.response.PaginationResponse;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.*;
import org.testcontainers.containers.PostgreSQLContainer;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AppInit.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(
    replace = AutoConfigureTestDatabase.Replace.NONE) // deactivate the default behaviour
public class CreatedBookControllerTest {

  private CreatedBook testCreatedBook;

  @Autowired private TestRestTemplate restTemplate;

  private static final PostgreSQLContainer postgresqlContainer =
      new PostgreSQLContainer("postgres:15")
          .withDatabaseName("flexicore-test")
          .withUsername("flexicore")
          .withPassword("flexicore");

  static {
    postgresqlContainer.start();
  }

  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
    registry.add("spring.datasource.username", postgresqlContainer::getUsername);
    registry.add("spring.datasource.password", postgresqlContainer::getPassword);
  }

  @BeforeAll
  public void init() {
    ResponseEntity<Object> authenticationResponse =
        this.restTemplate.postForEntity(
            "/login",
            new LoginRequest().setUsername("admin@flexicore.com").setPassword("admin"),
            Object.class);

    String authenticationKey =
        authenticationResponse.getHeaders().get(HttpHeaders.AUTHORIZATION).stream()
            .findFirst()
            .orElse(null);
    restTemplate
        .getRestTemplate()
        .setInterceptors(
            Collections.singletonList(
                (request, body, execution) -> {
                  request.getHeaders().add("Authorization", "Bearer " + authenticationKey);
                  return execution.execute(request, body);
                }));
  }

  @Test
  @Order(1)
  public void testCreatedBookCreate() {
    CreatedBookCreate request = new CreatedBookCreate();

    request.setTitle("test-string");

    ResponseEntity<CreatedBook> response =
        this.restTemplate.postForEntity(
            "/CreatedBook/createCreatedBook", request, CreatedBook.class);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    testCreatedBook = response.getBody();
    assertCreatedBook(request, testCreatedBook);
  }

  @Test
  @Order(2)
  public void testListAllCreatedBooks() {
    CreatedBookFilter request = new CreatedBookFilter();
    ParameterizedTypeReference<PaginationResponse<CreatedBook>> t =
        new ParameterizedTypeReference<>() {};

    ResponseEntity<PaginationResponse<CreatedBook>> response =
        this.restTemplate.exchange(
            "/CreatedBook/getAllCreatedBooks", HttpMethod.POST, new HttpEntity<>(request), t);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    PaginationResponse<CreatedBook> body = response.getBody();
    Assertions.assertNotNull(body);
    List<CreatedBook> CreatedBooks = body.getList();
    Assertions.assertNotEquals(0, CreatedBooks.size());
    Assertions.assertTrue(
        CreatedBooks.stream().anyMatch(f -> f.getId().equals(testCreatedBook.getId())));
  }

  public void assertCreatedBook(CreatedBookCreate request, CreatedBook testCreatedBook) {
    Assertions.assertNotNull(testCreatedBook);
    if (request.getTitle() != null) {
      Assertions.assertEquals(request.getTitle(), testCreatedBook.getTitle());
    }
  }

  @Test
  @Order(3)
  public void testCreatedBookUpdate() {
    CreatedBookUpdate request = new CreatedBookUpdate().setId(testCreatedBook.getId());

    ResponseEntity<CreatedBook> response =
        this.restTemplate.exchange(
            "/CreatedBook/updateCreatedBook",
            HttpMethod.PUT,
            new HttpEntity<>(request),
            CreatedBook.class);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    testCreatedBook = response.getBody();
    assertCreatedBook(request, testCreatedBook);
  }
}
