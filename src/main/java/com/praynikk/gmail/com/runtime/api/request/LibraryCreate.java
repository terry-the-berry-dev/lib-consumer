package com.praynikk.gmail.com.runtime.api.request;

public class LibraryCreate {

  private String name;

  public LibraryCreate() {}

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return LibraryCreate
   */
  public <T extends LibraryCreate> T setName(String name) {
    this.name = name;
    return (T) this;
  }
}
