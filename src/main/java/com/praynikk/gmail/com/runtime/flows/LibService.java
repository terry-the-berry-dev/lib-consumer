package com.praynikk.gmail.com.runtime.flows;

import com.praynikk.gmail.com.runtime.api.OpenAPIdefinition;
import com.praynikk.gmail.com.runtime.security.UserSecurityContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class LibService {
  @Scheduled(fixedDelay = 15000)
  public void runSchedule() {
    run(null);
  }

  public void run(UserSecurityContext securityContext) {

    OpenAPIdefinition openapidefinition = new OpenAPIdefinition();
  }
}
