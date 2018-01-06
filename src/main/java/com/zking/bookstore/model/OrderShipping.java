package com.zking.bookstore.model;

public class OrderShipping {
    private Long orderShippingId;

    private String orderId;

    private String receiverName;

    private String receiverPhone;

    private String receiverZip;

    private String receiverAddress;

    private Long delivery;

    public OrderShipping(Long orderShippingId, String orderId, String receiverName, String receiverPhone, String receiverZip, String receiverAddress, Long delivery) {
        this.orderShippingId = orderShippingId;
        this.orderId = orderId;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverZip = receiverZip;
        this.receiverAddress = receiverAddress;
        this.delivery = delivery;
    }

    public OrderShipping() {
        super();
    }

    public Long getOrderShippingId() {
        return orderShippingId;
    }

    public void setOrderShippingId(Long orderShippingId) {
        this.orderShippingId = orderShippingId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Long getDelivery() {
        return delivery;
    }

    public void setDelivery(Long delivery) {
        this.delivery = delivery;
    }
}