package com.praynikk.gmail.com.runtime.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
@EnableWebSecurity
public class OAuth2ClientSecurityConfig {

  private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
  private final ClientRegistrationRepository clientRegistrationRepository;

  public OAuth2ClientSecurityConfig(
      OAuth2AuthorizedClientService oAuth2AuthorizedClientService,
      ClientRegistrationRepository clientRegistrationRepository) {
    this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    this.clientRegistrationRepository = clientRegistrationRepository;
  }

  @Bean
  OAuth2AuthorizedClientManager authorizedClientManager() {
    var authorizedClientProvider =
        OAuth2AuthorizedClientProviderBuilder.builder()
            .authorizationCode()
            .refreshToken()
            .clientCredentials()
            .build();

    var authorizedClientManager =
        new AuthorizedClientServiceOAuth2AuthorizedClientManager(
            clientRegistrationRepository, oAuth2AuthorizedClientService);
    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

    return authorizedClientManager;
  }
}
