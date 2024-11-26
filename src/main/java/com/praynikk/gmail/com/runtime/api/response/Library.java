package com.praynikk.gmail.com.runtime.api.response;

public class Library {

  private String id;

  private String name;

  public Library() {}

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return Library
   */
  public <T extends Library> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return Library
   */
  public <T extends Library> T setName(String name) {
    this.name = name;
    return (T) this;
  }
}
