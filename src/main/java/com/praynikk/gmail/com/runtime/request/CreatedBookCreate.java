package com.praynikk.gmail.com.runtime.request;

/** Object Used to Create CreatedBook */
public class CreatedBookCreate {

  private String title;

  public CreatedBookCreate() {}

  /**
   * @return title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @param title to set
   * @return CreatedBookCreate
   */
  public <T extends CreatedBookCreate> T setTitle(String title) {
    this.title = title;
    return (T) this;
  }
}
