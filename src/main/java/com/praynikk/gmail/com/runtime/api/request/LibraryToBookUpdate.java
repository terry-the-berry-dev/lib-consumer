package com.praynikk.gmail.com.runtime.api.request;

public class LibraryToBookUpdate {

  private String bookId;

  private String libraryId;

  private String id;

  public LibraryToBookUpdate() {}

  /**
   * @return bookId
   */
  public String getBookId() {
    return this.bookId;
  }

  /**
   * @param bookId to set
   * @return LibraryToBookUpdate
   */
  public <T extends LibraryToBookUpdate> T setBookId(String bookId) {
    this.bookId = bookId;
    return (T) this;
  }

  /**
   * @return libraryId
   */
  public String getLibraryId() {
    return this.libraryId;
  }

  /**
   * @param libraryId to set
   * @return LibraryToBookUpdate
   */
  public <T extends LibraryToBookUpdate> T setLibraryId(String libraryId) {
    this.libraryId = libraryId;
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
   * @return LibraryToBookUpdate
   */
  public <T extends LibraryToBookUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
