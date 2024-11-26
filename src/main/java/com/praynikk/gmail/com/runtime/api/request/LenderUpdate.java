package com.praynikk.gmail.com.runtime.api.request;

public class LenderUpdate {

  private String name;

  private String id;

  public LenderUpdate() {}

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return LenderUpdate
   */
  public <T extends LenderUpdate> T setName(String name) {
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
   * @return LenderUpdate
   */
  public <T extends LenderUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
