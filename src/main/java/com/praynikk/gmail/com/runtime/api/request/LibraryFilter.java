package com.praynikk.gmail.com.runtime.api.request;

import java.util.List;

public class LibraryFilter {

  private Integer currentPage;

  private List<String> id;

  private List<String> libraryLibraryToBooksIds;

  private List<String> name;

  private String nameLike;

  private Integer pageSize;

  public LibraryFilter() {}

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage to set
   * @return LibraryFilter
   */
  public <T extends LibraryFilter> T setCurrentPage(Integer currentPage) {
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
   * @return LibraryFilter
   */
  public <T extends LibraryFilter> T setId(List<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return libraryLibraryToBooksIds
   */
  public List<String> getLibraryLibraryToBooksIds() {
    return this.libraryLibraryToBooksIds;
  }

  /**
   * @param libraryLibraryToBooksIds to set
   * @return LibraryFilter
   */
  public <T extends LibraryFilter> T setLibraryLibraryToBooksIds(
      List<String> libraryLibraryToBooksIds) {
    this.libraryLibraryToBooksIds = libraryLibraryToBooksIds;
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
   * @return LibraryFilter
   */
  public <T extends LibraryFilter> T setName(List<String> name) {
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
   * @return LibraryFilter
   */
  public <T extends LibraryFilter> T setNameLike(String nameLike) {
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
   * @return LibraryFilter
   */
  public <T extends LibraryFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }
}
