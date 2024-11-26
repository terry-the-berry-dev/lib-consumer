package com.praynikk.gmail.com.runtime.api.response;

public class Book {

  private String id;

  private String title;

  private Integer numberOfBooks;

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

  /**
   * @return title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @param title to set
   * @return Book
   */
  public <T extends Book> T setTitle(String title) {
    this.title = title;
    return (T) this;
  }

  /**
   * @return numberOfBooks
   */
  public Integer getNumberOfBooks() {
    return this.numberOfBooks;
  }

  /**
   * @param numberOfBooks to set
   * @return Book
   */
  public <T extends Book> T setNumberOfBooks(Integer numberOfBooks) {
    this.numberOfBooks = numberOfBooks;
    return (T) this;
  }
}
