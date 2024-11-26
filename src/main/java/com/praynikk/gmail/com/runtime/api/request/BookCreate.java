package com.praynikk.gmail.com.runtime.api.request;

public class BookCreate {

  private Integer numberOfBooks;

  private String title;

  public BookCreate() {}

  /**
   * @return numberOfBooks
   */
  public Integer getNumberOfBooks() {
    return this.numberOfBooks;
  }

  /**
   * @param numberOfBooks to set
   * @return BookCreate
   */
  public <T extends BookCreate> T setNumberOfBooks(Integer numberOfBooks) {
    this.numberOfBooks = numberOfBooks;
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
   * @return BookCreate
   */
  public <T extends BookCreate> T setTitle(String title) {
    this.title = title;
    return (T) this;
  }
}
