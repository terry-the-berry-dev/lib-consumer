package com.praynikk.gmail.com.runtime.api.response;

public class LibraryToBook {

  private Library library;

  private Book book;

  private String id;

  public LibraryToBook() {}

  /**
   * @return library
   */
  public Library getLibrary() {
    return this.library;
  }

  /**
   * @param library to set
   * @return LibraryToBook
   */
  public <T extends LibraryToBook> T setLibrary(Library library) {
    this.library = library;
    return (T) this;
  }

  /**
   * @return book
   */
  public Book getBook() {
    return this.book;
  }

  /**
   * @param book to set
   * @return LibraryToBook
   */
  public <T extends LibraryToBook> T setBook(Book book) {
    this.book = book;
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
   * @return LibraryToBook
   */
  public <T extends LibraryToBook> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
