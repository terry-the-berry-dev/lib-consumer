package com.praynikk.gmail.com.runtime.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.praynikk.gmail.com.runtime.api.request.AppUserCreate;
import com.praynikk.gmail.com.runtime.api.request.AppUserFilter;
import com.praynikk.gmail.com.runtime.api.request.AppUserUpdate;
import com.praynikk.gmail.com.runtime.api.request.BookCreate;
import com.praynikk.gmail.com.runtime.api.request.BookFilter;
import com.praynikk.gmail.com.runtime.api.request.BookUpdate;
import com.praynikk.gmail.com.runtime.api.request.LenderCreate;
import com.praynikk.gmail.com.runtime.api.request.LenderFilter;
import com.praynikk.gmail.com.runtime.api.request.LenderToBookCreate;
import com.praynikk.gmail.com.runtime.api.request.LenderToBookFilter;
import com.praynikk.gmail.com.runtime.api.request.LenderToBookUpdate;
import com.praynikk.gmail.com.runtime.api.request.LenderUpdate;
import com.praynikk.gmail.com.runtime.api.request.LibraryCreate;
import com.praynikk.gmail.com.runtime.api.request.LibraryFilter;
import com.praynikk.gmail.com.runtime.api.request.LibraryToBookCreate;
import com.praynikk.gmail.com.runtime.api.request.LibraryToBookFilter;
import com.praynikk.gmail.com.runtime.api.request.LibraryToBookUpdate;
import com.praynikk.gmail.com.runtime.api.request.LibraryUpdate;
import com.praynikk.gmail.com.runtime.api.request.LoginRequest;
import com.praynikk.gmail.com.runtime.api.response.AppUser;
import com.praynikk.gmail.com.runtime.api.response.Book;
import com.praynikk.gmail.com.runtime.api.response.Lender;
import com.praynikk.gmail.com.runtime.api.response.LenderToBook;
import com.praynikk.gmail.com.runtime.api.response.Library;
import com.praynikk.gmail.com.runtime.api.response.LibraryToBook;
import com.praynikk.gmail.com.runtime.api.response.Login200Response;
import com.praynikk.gmail.com.runtime.api.response.PaginationResponseAppUser;
import com.praynikk.gmail.com.runtime.api.response.PaginationResponseBook;
import com.praynikk.gmail.com.runtime.api.response.PaginationResponseLender;
import com.praynikk.gmail.com.runtime.api.response.PaginationResponseLenderToBook;
import com.praynikk.gmail.com.runtime.api.response.PaginationResponseLibrary;
import com.praynikk.gmail.com.runtime.api.response.PaginationResponseLibraryToBook;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

public class OpenAPIdefinition {

  private static final String DEFAULT_BASE_PATH =
      "https://library.praynikk-gmail-com-s-workspace.cluster.wizzdi.com";
  private static final Logger logger = LoggerFactory.getLogger(OpenAPIdefinition.class);

  private static final ObjectMapper objectMapper =
      new ObjectMapper()
          .setSerializationInclusion(JsonInclude.Include.NON_NULL)
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
          .registerModule(new JavaTimeModule());

  private String basePath = DEFAULT_BASE_PATH;
  private final RestTemplate restTemplate;

  public OpenAPIdefinition() {
    this.restTemplate = getRestTemplate();
  }

  public <T extends OpenAPIdefinition> T setBasePath(String basePath) {
    this.basePath = basePath;
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(basePath));
    return (T) this;
  }

  private RestTemplate getRestTemplate() {
    return new RestTemplateBuilder()
        .uriTemplateHandler(new DefaultUriBuilderFactory(DEFAULT_BASE_PATH))
        .additionalMessageConverters(
            new MappingJackson2HttpMessageConverter(objectMapper), new FormHttpMessageConverter())
        .build();
  }

  public ResponseEntity<Book> updateBook(BookUpdate bookUpdate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.PUT;
    String path = "/api/Book/updateBook";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<BookUpdate> entity = new HttpEntity<>(bookUpdate, headers);

    ParameterizedTypeReference<Book> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<LenderToBook> deleteLenderToBook(String id) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.DELETE;
    String path = "/api/LenderToBook/{id}";

    uriParameters.put("id", id);

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<Void> entity = new HttpEntity<>(null, headers);

    ParameterizedTypeReference<LenderToBook> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<PaginationResponseBook> getAllBooks(BookFilter bookFilter) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/Book/getAllBooks";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<BookFilter> entity = new HttpEntity<>(bookFilter, headers);

    ParameterizedTypeReference<PaginationResponseBook> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Book> createBook(BookCreate bookCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/Book/createBook";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<BookCreate> entity = new HttpEntity<>(bookCreate, headers);

    ParameterizedTypeReference<Book> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<AppUser> updateAppUser(AppUserUpdate appUserUpdate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.PUT;
    String path = "/api/AppUser/updateAppUser";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<AppUserUpdate> entity = new HttpEntity<>(appUserUpdate, headers);

    ParameterizedTypeReference<AppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<LenderToBook> updateLenderToBook(LenderToBookUpdate lenderToBookUpdate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.PUT;
    String path = "/api/LenderToBook/updateLenderToBook";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LenderToBookUpdate> entity = new HttpEntity<>(lenderToBookUpdate, headers);

    ParameterizedTypeReference<LenderToBook> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Library> createLibrary(LibraryCreate libraryCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/Library/createLibrary";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LibraryCreate> entity = new HttpEntity<>(libraryCreate, headers);

    ParameterizedTypeReference<Library> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<AppUser> createAppUser(AppUserCreate appUserCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/AppUser/createAppUser";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<AppUserCreate> entity = new HttpEntity<>(appUserCreate, headers);

    ParameterizedTypeReference<AppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<PaginationResponseAppUser> getAllAppUsers(AppUserFilter appUserFilter) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/AppUser/getAllAppUsers";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<AppUserFilter> entity = new HttpEntity<>(appUserFilter, headers);

    ParameterizedTypeReference<PaginationResponseAppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<PaginationResponseLenderToBook> getAllLenderToBooks(
      LenderToBookFilter lenderToBookFilter) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/LenderToBook/getAllLenderToBooks";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LenderToBookFilter> entity = new HttpEntity<>(lenderToBookFilter, headers);

    ParameterizedTypeReference<PaginationResponseLenderToBook> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<LibraryToBook> createLibraryToBook(
      LibraryToBookCreate libraryToBookCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/LibraryToBook/createLibraryToBook";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LibraryToBookCreate> entity = new HttpEntity<>(libraryToBookCreate, headers);

    ParameterizedTypeReference<LibraryToBook> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Library> updateLibrary(LibraryUpdate libraryUpdate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.PUT;
    String path = "/api/Library/updateLibrary";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LibraryUpdate> entity = new HttpEntity<>(libraryUpdate, headers);

    ParameterizedTypeReference<Library> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Login200Response> login(LoginRequest loginRequest) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/login";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LoginRequest> entity = new HttpEntity<>(loginRequest, headers);

    ParameterizedTypeReference<Login200Response> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<PaginationResponseLibrary> getAllLibraries(LibraryFilter libraryFilter) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/Library/getAllLibraries";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LibraryFilter> entity = new HttpEntity<>(libraryFilter, headers);

    ParameterizedTypeReference<PaginationResponseLibrary> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Book> deleteBook(String id) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.DELETE;
    String path = "/api/Book/{id}";

    uriParameters.put("id", id);

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<Void> entity = new HttpEntity<>(null, headers);

    ParameterizedTypeReference<Book> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<LibraryToBook> deleteLibraryToBook(String id) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.DELETE;
    String path = "/api/LibraryToBook/{id}";

    uriParameters.put("id", id);

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<Void> entity = new HttpEntity<>(null, headers);

    ParameterizedTypeReference<LibraryToBook> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Library> deleteLibrary(String id) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.DELETE;
    String path = "/api/Library/{id}";

    uriParameters.put("id", id);

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<Void> entity = new HttpEntity<>(null, headers);

    ParameterizedTypeReference<Library> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<PaginationResponseLibraryToBook> getAllLibraryToBooks(
      LibraryToBookFilter libraryToBookFilter) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/LibraryToBook/getAllLibraryToBooks";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LibraryToBookFilter> entity = new HttpEntity<>(libraryToBookFilter, headers);

    ParameterizedTypeReference<PaginationResponseLibraryToBook> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<LenderToBook> createLenderToBook(LenderToBookCreate lenderToBookCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/LenderToBook/createLenderToBook";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LenderToBookCreate> entity = new HttpEntity<>(lenderToBookCreate, headers);

    ParameterizedTypeReference<LenderToBook> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Lender> createLender(LenderCreate lenderCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/Lender/createLender";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LenderCreate> entity = new HttpEntity<>(lenderCreate, headers);

    ParameterizedTypeReference<Lender> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<AppUser> deleteAppUser(String id) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.DELETE;
    String path = "/api/AppUser/{id}";

    uriParameters.put("id", id);

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<Void> entity = new HttpEntity<>(null, headers);

    ParameterizedTypeReference<AppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<PaginationResponseLender> getAllLenders(LenderFilter lenderFilter) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/Lender/getAllLenders";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LenderFilter> entity = new HttpEntity<>(lenderFilter, headers);

    ParameterizedTypeReference<PaginationResponseLender> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<LibraryToBook> updateLibraryToBook(
      LibraryToBookUpdate libraryToBookUpdate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.PUT;
    String path = "/api/LibraryToBook/updateLibraryToBook";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LibraryToBookUpdate> entity = new HttpEntity<>(libraryToBookUpdate, headers);

    ParameterizedTypeReference<LibraryToBook> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Lender> deleteLender(String id) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.DELETE;
    String path = "/api/Lender/{id}";

    uriParameters.put("id", id);

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<Void> entity = new HttpEntity<>(null, headers);

    ParameterizedTypeReference<Lender> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<AppUser> register(AppUserCreate appUserCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/register";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<AppUserCreate> entity = new HttpEntity<>(appUserCreate, headers);

    ParameterizedTypeReference<AppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Lender> updateLender(LenderUpdate lenderUpdate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.PUT;
    String path = "/api/Lender/updateLender";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LenderUpdate> entity = new HttpEntity<>(lenderUpdate, headers);

    ParameterizedTypeReference<Lender> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }
}
