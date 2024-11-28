package com.praynikk.gmail.com.runtime.gmail.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.praynikk.gmail.com.runtime.api.config.OAuthClientCredentialsRestTemplateInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class GmailAPI {

  private static final String DEFAULT_BASE_PATH = "https://gmail.googleapis.com/";
  private static final Logger logger = LoggerFactory.getLogger(GmailAPI.class);

  private static final ObjectMapper objectMapper =
      new ObjectMapper()
          .setSerializationInclusion(JsonInclude.Include.NON_NULL)
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
          .registerModule(new JavaTimeModule());

  private String basePath = DEFAULT_BASE_PATH;
  private final RestTemplate restTemplate;

  public GmailAPI(
      OAuth2AuthorizedClientManager authorizedClientManager,
      ClientRegistrationRepository clientRegistrationRepository) {
    this.restTemplate = getRestTemplate(authorizedClientManager, clientRegistrationRepository);
  }

  public <T extends GmailAPI> T setBasePath(String basePath) {
    this.basePath = basePath;
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(basePath));
    return (T) this;
  }

  private RestTemplate getRestTemplate(
      OAuth2AuthorizedClientManager authorizedClientManager,
      ClientRegistrationRepository clientRegistrationRepository) {
    var clientRegistration =
        clientRegistrationRepository.findByRegistrationId(getClass().getSimpleName());
    return new RestTemplateBuilder()
        .additionalInterceptors(
            new OAuthClientCredentialsRestTemplateInterceptor(
                authorizedClientManager, clientRegistration))
        .uriTemplateHandler(new DefaultUriBuilderFactory(DEFAULT_BASE_PATH))
        .additionalMessageConverters(
            new MappingJackson2HttpMessageConverter(objectMapper), new FormHttpMessageConverter())
        .build();
  }
}
