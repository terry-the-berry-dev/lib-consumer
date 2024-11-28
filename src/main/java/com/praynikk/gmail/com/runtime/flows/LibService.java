package com.praynikk.gmail.com.runtime.flows;

import com.praynikk.gmail.com.runtime.api.OpenAPIdefinition;
import com.praynikk.gmail.com.runtime.api.request.LoginRequest;
import com.praynikk.gmail.com.runtime.security.UserSecurityContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class LibService {
  @Value("${library.admin.username}")
  private java.lang.String libraryadminusername;

  @Value("${library.admin.password}")
  private java.lang.String libraryadminpassword;

  @Scheduled(fixedDelay = 15000)
  public void runSchedule() {
    run(null);
  }

  public void run(UserSecurityContext securityContext) {

    OpenAPIdefinition openApi =
        new OpenAPIdefinition()
            .setBasePath("https://library.praynikk-gmail-com-s-workspace.cluster.wizzdi.com/api");

    var loginResponse =
        openApi.login(
            new LoginRequest()
                .setUsername(this.libraryadminusername)
                .setPassword(this.libraryadminpassword));

    if (!(loginResponse.getStatusCode().is2xxSuccessful())) {

      throw new org.springframework.web.server.ResponseStatusException(
          HttpStatus.FORBIDDEN, "Cannot login");
    }

    java.lang.String openAPIAuthToken =
        loginResponse.getHeaders().getFirst("authorization").toString();
  }
}
