package com.praynikk.gmail.com.runtime.api.request;

import java.util.List;

public class BookFilter {

  private List<String> bookLenderToBooksIds;

  private List<String> bookLibraryToBooksIds;

  private Integer currentPage;

  private List<String> id;

  private Integer numberOfBooksEnd;

  private Integer numberOfBooksStart;

  private Integer pageSize;

  private List<String> title;

  private String titleLike;

  public BookFilter() {}

  /**
   * @return bookLenderToBooksIds
   */
  public List<String> getBookLenderToBooksIds() {
    return this.bookLenderToBooksIds;
  }

  /**
   * @param bookLenderToBooksIds to set
   * @return BookFilter
   */
  public <T extends BookFilter> T setBookLenderToBooksIds(List<String> bookLenderToBooksIds) {
    this.bookLenderToBooksIds = bookLenderToBooksIds;
    return (T) this;
  }

  /**
   * @return bookLibraryToBooksIds
   */
  public List<String> getBookLibraryToBooksIds() {
    return this.bookLibraryToBooksIds;
  }

  /**
   * @param bookLibraryToBooksIds to set
   * @return BookFilter
   */
  public <T extends BookFilter> T setBookLibraryToBooksIds(List<String> bookLibraryToBooksIds) {
    this.bookLibraryToBooksIds = bookLibraryToBooksIds;
    return (T) this;
  }

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage to set
   * @return BookFilter
   */
  public <T extends BookFilter> T setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return (T) this;
  }

  /**
   * @return id
   */
  public List<String> getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return BookFilter
   */
  public <T extends BookFilter> T setId(List<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return numberOfBooksEnd
   */
  public Integer getNumberOfBooksEnd() {
    return this.numberOfBooksEnd;
  }

  /**
   * @param numberOfBooksEnd to set
   * @return BookFilter
   */
  public <T extends BookFilter> T setNumberOfBooksEnd(Integer numberOfBooksEnd) {
    this.numberOfBooksEnd = numberOfBooksEnd;
    return (T) this;
  }

  /**
   * @return numberOfBooksStart
   */
  public Integer getNumberOfBooksStart() {
    return this.numberOfBooksStart;
  }

  /**
   * @param numberOfBooksStart to set
   * @return BookFilter
   */
  public <T extends BookFilter> T setNumberOfBooksStart(Integer numberOfBooksStart) {
    this.numberOfBooksStart = numberOfBooksStart;
    return (T) this;
  }

  /**
   * @return pageSize
   */
  public Integer getPageSize() {
    return this.pageSize;
  }

  /**
   * @param pageSize to set
   * @return BookFilter
   */
  public <T extends BookFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }

  /**
   * @return title
   */
  public List<String> getTitle() {
    return this.title;
  }

  /**
   * @param title to set
   * @return BookFilter
   */
  public <T extends BookFilter> T setTitle(List<String> title) {
    this.title = title;
    return (T) this;
  }

  /**
   * @return titleLike
   */
  public String getTitleLike() {
    return this.titleLike;
  }

  /**
   * @param titleLike to set
   * @return BookFilter
   */
  public <T extends BookFilter> T setTitleLike(String titleLike) {
    this.titleLike = titleLike;
    return (T) this;
  }
}
