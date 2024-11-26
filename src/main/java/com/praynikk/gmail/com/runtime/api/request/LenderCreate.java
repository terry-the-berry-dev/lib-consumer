package com.praynikk.gmail.com.runtime.api.request;

public class LenderCreate {

  private String name;

  public LenderCreate() {}

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return LenderCreate
   */
  public <T extends LenderCreate> T setName(String name) {
    this.name = name;
    return (T) this;
  }
}
