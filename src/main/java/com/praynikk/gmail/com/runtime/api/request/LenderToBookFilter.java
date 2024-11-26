package com.praynikk.gmail.com.runtime.api.request;

import java.util.List;

public class LenderToBookFilter {

  private List<String> bookIds;

  private Integer currentPage;

  private List<String> id;

  private List<String> lenderIds;

  private Integer pageSize;

  public LenderToBookFilter() {}

  /**
   * @return bookIds
   */
  public List<String> getBookIds() {
    return this.bookIds;
  }

  /**
   * @param bookIds to set
   * @return LenderToBookFilter
   */
  public <T extends LenderToBookFilter> T setBookIds(List<String> bookIds) {
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
   * @return LenderToBookFilter
   */
  public <T extends LenderToBookFilter> T setCurrentPage(Integer currentPage) {
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
   * @return LenderToBookFilter
   */
  public <T extends LenderToBookFilter> T setId(List<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return lenderIds
   */
  public List<String> getLenderIds() {
    return this.lenderIds;
  }

  /**
   * @param lenderIds to set
   * @return LenderToBookFilter
   */
  public <T extends LenderToBookFilter> T setLenderIds(List<String> lenderIds) {
    this.lenderIds = lenderIds;
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
   * @return LenderToBookFilter
   */
  public <T extends LenderToBookFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }
}
