package com.praynikk.gmail.com.runtime.api.request;

import java.util.List;

public class LenderFilter {

  private Integer currentPage;

  private List<String> id;

  private List<String> lenderLenderToBooksIds;

  private List<String> name;

  private String nameLike;

  private Integer pageSize;

  public LenderFilter() {}

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage to set
   * @return LenderFilter
   */
  public <T extends LenderFilter> T setCurrentPage(Integer currentPage) {
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
   * @return LenderFilter
   */
  public <T extends LenderFilter> T setId(List<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return lenderLenderToBooksIds
   */
  public List<String> getLenderLenderToBooksIds() {
    return this.lenderLenderToBooksIds;
  }

  /**
   * @param lenderLenderToBooksIds to set
   * @return LenderFilter
   */
  public <T extends LenderFilter> T setLenderLenderToBooksIds(List<String> lenderLenderToBooksIds) {
    this.lenderLenderToBooksIds = lenderLenderToBooksIds;
    return (T) this;
  }

  /**
   * @return name
   */
  public List<String> getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return LenderFilter
   */
  public <T extends LenderFilter> T setName(List<String> name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return nameLike
   */
  public String getNameLike() {
    return this.nameLike;
  }

  /**
   * @param nameLike to set
   * @return LenderFilter
   */
  public <T extends LenderFilter> T setNameLike(String nameLike) {
    this.nameLike = nameLike;
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
   * @return LenderFilter
   */
  public <T extends LenderFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }
}
