package com.praynikk.gmail.com.runtime.flows;

import com.praynikk.gmail.com.runtime.security.UserSecurityContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class LibService {
  @Scheduled(cron = "0 5 19 * * SUN ")
  public void runSchedule() {
    run(null);
  }

  public void run(UserSecurityContext securityContext) {}
}
