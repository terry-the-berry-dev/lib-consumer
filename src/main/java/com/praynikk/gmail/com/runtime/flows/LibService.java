package com.praynikk.gmail.com.runtime.flows;

import com.praynikk.gmail.com.runtime.Book;
import com.praynikk.gmail.com.runtime.api.OpenAPIdefinition;
import com.praynikk.gmail.com.runtime.api.request.BookCreate;
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

  public Book run(UserSecurityContext securityContext) {

    OpenAPIdefinition openapidefinition = new OpenAPIdefinition();

    var createdBook1 =
        openapidefinition.createBook(new BookCreate().setTitle("new title").setNumberOfBooks(1));

    return new Book().setId("2");
  }
}
