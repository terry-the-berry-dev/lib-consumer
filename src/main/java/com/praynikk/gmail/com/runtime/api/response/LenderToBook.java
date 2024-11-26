package com.praynikk.gmail.com.runtime.api.response;

public class LenderToBook {

  private Lender lender;

  private Book book;

  private String id;

  public LenderToBook() {}

  /**
   * @return lender
   */
  public Lender getLender() {
    return this.lender;
  }

  /**
   * @param lender to set
   * @return LenderToBook
   */
  public <T extends LenderToBook> T setLender(Lender lender) {
    this.lender = lender;
    return (T) this;
  }

  /**
   * @return book
   */
  public Book getBook() {
    return this.book;
  }

  /**
   * @param book to set
   * @return LenderToBook
   */
  public <T extends LenderToBook> T setBook(Book book) {
    this.book = book;
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
   * @return LenderToBook
   */
  public <T extends LenderToBook> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
