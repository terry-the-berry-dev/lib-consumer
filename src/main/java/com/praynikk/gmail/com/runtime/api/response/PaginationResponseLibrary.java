package com.praynikk.gmail.com.runtime.api.response;

import java.util.List;

public class PaginationResponseLibrary {

  private List<Library> list;

  private Integer totalRecords;

  private Integer totalPages;

  private Integer startPage;

  private Integer endPage;

  public PaginationResponseLibrary() {}

  /**
   * @return list
   */
  public List<Library> getList() {
    return this.list;
  }

  /**
   * @param list to set
   * @return PaginationResponseLibrary
   */
  public <T extends PaginationResponseLibrary> T setList(List<Library> list) {
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
   * @return PaginationResponseLibrary
   */
  public <T extends PaginationResponseLibrary> T setTotalRecords(Integer totalRecords) {
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
   * @return PaginationResponseLibrary
   */
  public <T extends PaginationResponseLibrary> T setTotalPages(Integer totalPages) {
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
   * @return PaginationResponseLibrary
   */
  public <T extends PaginationResponseLibrary> T setStartPage(Integer startPage) {
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
   * @return PaginationResponseLibrary
   */
  public <T extends PaginationResponseLibrary> T setEndPage(Integer endPage) {
    this.endPage = endPage;
    return (T) this;
  }
}
