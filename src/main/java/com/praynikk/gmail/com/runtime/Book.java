package com.praynikk.gmail.com.runtime;

public class Book {

  private String id;

  public Book() {}

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return Book
   */
  public <T extends Book> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
