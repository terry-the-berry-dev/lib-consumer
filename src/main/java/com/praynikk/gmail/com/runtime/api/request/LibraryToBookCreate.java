package com.praynikk.gmail.com.runtime.api.request;

public class LibraryToBookCreate {

  private String bookId;

  private String libraryId;

  public LibraryToBookCreate() {}

  /**
   * @return bookId
   */
  public String getBookId() {
    return this.bookId;
  }

  /**
   * @param bookId to set
   * @return LibraryToBookCreate
   */
  public <T extends LibraryToBookCreate> T setBookId(String bookId) {
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
   * @return LibraryToBookCreate
   */
  public <T extends LibraryToBookCreate> T setLibraryId(String libraryId) {
    this.libraryId = libraryId;
    return (T) this;
  }
}
