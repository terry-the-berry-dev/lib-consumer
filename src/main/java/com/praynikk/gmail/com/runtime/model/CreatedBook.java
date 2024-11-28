package com.praynikk.gmail.com.runtime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CreatedBook {

  @Id private String id;

  private String title;

  public CreatedBook() {}

  /**
   * @return id
   */
  @Id
  public String getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return CreatedBook
   */
  public <T extends CreatedBook> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @param title to set
   * @return CreatedBook
   */
  public <T extends CreatedBook> T setTitle(String title) {
    this.title = title;
    return (T) this;
  }
}
