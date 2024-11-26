package com.praynikk.gmail.com.runtime.api.request;

public class LenderToBookUpdate {

  private String bookId;

  private String lenderId;

  private String id;

  public LenderToBookUpdate() {}

  /**
   * @return bookId
   */
  public String getBookId() {
    return this.bookId;
  }

  /**
   * @param bookId to set
   * @return LenderToBookUpdate
   */
  public <T extends LenderToBookUpdate> T setBookId(String bookId) {
    this.bookId = bookId;
    return (T) this;
  }

  /**
   * @return lenderId
   */
  public String getLenderId() {
    return this.lenderId;
  }

  /**
   * @param lenderId to set
   * @return LenderToBookUpdate
   */
  public <T extends LenderToBookUpdate> T setLenderId(String lenderId) {
    this.lenderId = lenderId;
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
   * @return LenderToBookUpdate
   */
  public <T extends LenderToBookUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
