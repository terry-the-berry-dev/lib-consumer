package com.praynikk.gmail.com.runtime.api.request;

public class LibraryUpdate {

  private String name;

  private String id;

  public LibraryUpdate() {}

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return LibraryUpdate
   */
  public <T extends LibraryUpdate> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return LibraryUpdate
   */
  public <T extends LibraryUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
