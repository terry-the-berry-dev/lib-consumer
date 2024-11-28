package com.praynikk.gmail.com.runtime.request;

import jakarta.validation.constraints.Min;
import java.util.Set;

/** Object Used to List CreatedBook */
public class CreatedBookFilter {

  @Min(
      value = 0,
      groups = {})
  private Integer currentPage;

  private Set<String> id;

  @Min(
      value = 1,
      groups = {})
  private Integer pageSize;

  private Set<String> title;

  private String titleLike;

  public CreatedBookFilter() {}

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage to set
   * @return CreatedBookFilter
   */
  public <T extends CreatedBookFilter> T setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return (T) this;
  }

  /**
   * @return id
   */
  public Set<String> getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return CreatedBookFilter
   */
  public <T extends CreatedBookFilter> T setId(Set<String> id) {
    this.id = id;
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
   * @return CreatedBookFilter
   */
  public <T extends CreatedBookFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }

  /**
   * @return title
   */
  public Set<String> getTitle() {
    return this.title;
  }

  /**
   * @param title to set
   * @return CreatedBookFilter
   */
  public <T extends CreatedBookFilter> T setTitle(Set<String> title) {
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
   * @return CreatedBookFilter
   */
  public <T extends CreatedBookFilter> T setTitleLike(String titleLike) {
    this.titleLike = titleLike;
    return (T) this;
  }
}
