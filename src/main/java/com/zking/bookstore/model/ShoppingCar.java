package com.zking.bookstore.model;

import java.util.Date;

public class ShoppingCar {
    private Long shoppingcarId;

    private Long userId;

    private Long bookId;

    private Integer bookNum;

    private Date created;

    private Date updated;

    private Book book;

    public ShoppingCar(Long shoppingcarId, Long userId, Long bookId, Integer bookNum, Date created, Date updated) {
        this.shoppingcarId = shoppingcarId;
        this.userId = userId;
        this.bookId = bookId;
        this.bookNum = bookNum;
        this.created = created;
        this.updated = updated;
    }

    public ShoppingCar() {
        super();
    }

    public Long getShoppingcarId() {
        return shoppingcarId;
    }

    public void setShoppingcarId(Long shoppingcarId) {
        this.shoppingcarId = shoppingcarId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}