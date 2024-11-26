package com.praynikk.gmail.com.runtime.api.request;

import java.util.List;

public class LibraryToBookFilter {

  private List<String> bookIds;

  private Integer currentPage;

  private List<String> id;

  private List<String> libraryIds;

  private Integer pageSize;

  public LibraryToBookFilter() {}

  /**
   * @return bookIds
   */
  public List<String> getBookIds() {
    return this.bookIds;
  }

  /**
   * @param bookIds to set
   * @return LibraryToBookFilter
   */
  public <T extends LibraryToBookFilter> T setBookIds(List<String> bookIds) {
    this.bookIds = bookIds;
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
   * @return LibraryToBookFilter
   */
  public <T extends LibraryToBookFilter> T setCurrentPage(Integer currentPage) {
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
   * @return LibraryToBookFilter
   */
  public <T extends LibraryToBookFilter> T setId(List<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return libraryIds
   */
  public List<String> getLibraryIds() {
    return this.libraryIds;
  }

  /**
   * @param libraryIds to set
   * @return LibraryToBookFilter
   */
  public <T extends LibraryToBookFilter> T setLibraryIds(List<String> libraryIds) {
    this.libraryIds = libraryIds;
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
   * @return LibraryToBookFilter
   */
  public <T extends LibraryToBookFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }
}
