package com.praynikk.gmail.com.runtime.api.response;

import java.util.List;

public class PaginationResponseLibraryToBook {

  private List<LibraryToBook> list;

  private Integer totalRecords;

  private Integer totalPages;

  private Integer startPage;

  private Integer endPage;

  public PaginationResponseLibraryToBook() {}

  /**
   * @return list
   */
  public List<LibraryToBook> getList() {
    return this.list;
  }

  /**
   * @param list to set
   * @return PaginationResponseLibraryToBook
   */
  public <T extends PaginationResponseLibraryToBook> T setList(List<LibraryToBook> list) {
    this.list = list;
    return (T) this;
  }

  /**
   * @return totalRecords
   */
  public Integer getTotalRecords() {
    return this.totalRecords;
  }

  /**
   * @param totalRecords to set
   * @return PaginationResponseLibraryToBook
   */
  public <T extends PaginationResponseLibraryToBook> T setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
    return (T) this;
  }

  /**
   * @return totalPages
   */
  public Integer getTotalPages() {
    return this.totalPages;
  }

  /**
   * @param totalPages to set
   * @return PaginationResponseLibraryToBook
   */
  public <T extends PaginationResponseLibraryToBook> T setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return (T) this;
  }

  /**
   * @return startPage
   */
  public Integer getStartPage() {
    return this.startPage;
  }

  /**
   * @param startPage to set
   * @return PaginationResponseLibraryToBook
   */
  public <T extends PaginationResponseLibraryToBook> T setStartPage(Integer startPage) {
    this.startPage = startPage;
    return (T) this;
  }

  /**
   * @return endPage
   */
  public Integer getEndPage() {
    return this.endPage;
  }

  /**
   * @param endPage to set
   * @return PaginationResponseLibraryToBook
   */
  public <T extends PaginationResponseLibraryToBook> T setEndPage(Integer endPage) {
    this.endPage = endPage;
    return (T) this;
  }
}
