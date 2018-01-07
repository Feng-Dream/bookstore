package com.zking.bookstore.model;

public class OrderItem {
    private Long orderItemId;

    private Long orderId;

    private Long bookId;

    private Float bookPrice;

    private Integer bookNum;

    private Float totalFee;

    public OrderItem(Long orderItemId, Long orderId, Long bookId, Float bookPrice, Integer bookNum, Float totalFee) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.bookNum = bookNum;
        this.totalFee = totalFee;
    }

    public OrderItem() {
        super();
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Float totalFee) {
        this.totalFee = totalFee;
    }
}