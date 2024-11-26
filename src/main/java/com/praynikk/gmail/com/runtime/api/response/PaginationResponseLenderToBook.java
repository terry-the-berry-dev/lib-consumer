package com.praynikk.gmail.com.runtime.api.response;

import java.util.List;

public class PaginationResponseLenderToBook {

  private List<LenderToBook> list;

  private Integer totalRecords;

  private Integer totalPages;

  private Integer startPage;

  private Integer endPage;

  public PaginationResponseLenderToBook() {}

  /**
   * @return list
   */
  public List<LenderToBook> getList() {
    return this.list;
  }

  /**
   * @param list to set
   * @return PaginationResponseLenderToBook
   */
  public <T extends PaginationResponseLenderToBook> T setList(List<LenderToBook> list) {
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
   * @return PaginationResponseLenderToBook
   */
  public <T extends PaginationResponseLenderToBook> T setTotalRecords(Integer totalRecords) {
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
   * @return PaginationResponseLenderToBook
   */
  public <T extends PaginationResponseLenderToBook> T setTotalPages(Integer totalPages) {
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
   * @return PaginationResponseLenderToBook
   */
  public <T extends PaginationResponseLenderToBook> T setStartPage(Integer startPage) {
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
   * @return PaginationResponseLenderToBook
   */
  public <T extends PaginationResponseLenderToBook> T setEndPage(Integer endPage) {
    this.endPage = endPage;
    return (T) this;
  }
}
