package com.praynikk.gmail.com.runtime;

import com.praynikk.gmail.com.runtime.request.AppUserCreate;
import com.praynikk.gmail.com.runtime.security.UserSecurityContext;
import com.praynikk.gmail.com.runtime.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppInitConfig {

  @Autowired
  @Qualifier("adminSecurityContext")
  private UserSecurityContext securityContext;

  @Configuration
  public static class UserConfig {
    @Bean
    @Qualifier("adminSecurityContext")
    public UserSecurityContext adminSecurityContext(AppUserService appUserService) {
      com.praynikk.gmail.com.runtime.model.AppUser admin =
          appUserService.createAppUser(
              new AppUserCreate().setUsername("admin@flexicore.com").setPassword("admin"), null);
      return new UserSecurityContext(admin);
    }
  }
}
