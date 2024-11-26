package com.praynikk.gmail.com.runtime.api.request;

public class LenderToBookCreate {

  private String bookId;

  private String lenderId;

  public LenderToBookCreate() {}

  /**
   * @return bookId
   */
  public String getBookId() {
    return this.bookId;
  }

  /**
   * @param bookId to set
   * @return LenderToBookCreate
   */
  public <T extends LenderToBookCreate> T setBookId(String bookId) {
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
   * @return LenderToBookCreate
   */
  public <T extends LenderToBookCreate> T setLenderId(String lenderId) {
    this.lenderId = lenderId;
    return (T) this;
  }
}
