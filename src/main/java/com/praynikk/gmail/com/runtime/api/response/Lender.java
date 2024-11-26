package com.praynikk.gmail.com.runtime.api.response;

public class Lender {

  private String id;

  private String name;

  public Lender() {}

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return Lender
   */
  public <T extends Lender> T setId(String id) {
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
   * @return Lender
   */
  public <T extends Lender> T setName(String name) {
    this.name = name;
    return (T) this;
  }
}
