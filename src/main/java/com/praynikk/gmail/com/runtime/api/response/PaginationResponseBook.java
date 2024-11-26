package com.praynikk.gmail.com.runtime.api.response;

import java.util.List;

public class PaginationResponseBook {

  private List<Book> list;

  private Integer totalRecords;

  private Integer totalPages;

  private Integer startPage;

  private Integer endPage;

  public PaginationResponseBook() {}

  /**
   * @return list
   */
  public List<Book> getList() {
    return this.list;
  }

  /**
   * @param list to set
   * @return PaginationResponseBook
   */
  public <T extends PaginationResponseBook> T setList(List<Book> list) {
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
   * @return PaginationResponseBook
   */
  public <T extends PaginationResponseBook> T setTotalRecords(Integer totalRecords) {
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
   * @return PaginationResponseBook
   */
  public <T extends PaginationResponseBook> T setTotalPages(Integer totalPages) {
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
   * @return PaginationResponseBook
   */
  public <T extends PaginationResponseBook> T setStartPage(Integer startPage) {
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
   * @return PaginationResponseBook
   */
  public <T extends PaginationResponseBook> T setEndPage(Integer endPage) {
    this.endPage = endPage;
    return (T) this;
  }
}
