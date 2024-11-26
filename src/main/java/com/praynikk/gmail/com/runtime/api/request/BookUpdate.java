package com.praynikk.gmail.com.runtime.api.request;

public class BookUpdate {

  private Integer numberOfBooks;

  private String title;

  private String id;

  public BookUpdate() {}

  /**
   * @return numberOfBooks
   */
  public Integer getNumberOfBooks() {
    return this.numberOfBooks;
  }

  /**
   * @param numberOfBooks to set
   * @return BookUpdate
   */
  public <T extends BookUpdate> T setNumberOfBooks(Integer numberOfBooks) {
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
   * @return BookUpdate
   */
  public <T extends BookUpdate> T setTitle(String title) {
    this.title = title;
    return (T) this;
  }

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return BookUpdate
   */
  public <T extends BookUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
