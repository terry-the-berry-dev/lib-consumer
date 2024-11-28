package com.praynikk.gmail.com.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.praynikk.gmail.com.runtime.model.CreatedBook;
import com.praynikk.gmail.com.runtime.validation.IdValid;
import com.praynikk.gmail.com.runtime.validation.Update;

/** Object Used to Update CreatedBook */
@IdValid.List({
  @IdValid(
      field = "id",
      fieldType = CreatedBook.class,
      targetField = "createdBook",
      groups = {Update.class})
})
public class CreatedBookUpdate extends CreatedBookCreate {

  @JsonIgnore private CreatedBook createdBook;

  private String id;

  public CreatedBookUpdate() {}

  /**
   * @return createdBook
   */
  @JsonIgnore
  public CreatedBook getCreatedBook() {
    return this.createdBook;
  }

  /**
   * @param createdBook to set
   * @return CreatedBookUpdate
   */
  public <T extends CreatedBookUpdate> T setCreatedBook(CreatedBook createdBook) {
    this.createdBook = createdBook;
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
   * @return CreatedBookUpdate
   */
  public <T extends CreatedBookUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
