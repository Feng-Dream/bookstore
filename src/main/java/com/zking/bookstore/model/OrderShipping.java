package com.zking.bookstore.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class OrderShipping {
    private Long orderShippingId;

    private Long orderId;

    @NotBlank(message = "收货人不能为空")
    private String receiverName;

    @NotBlank(message = "收货人电话不能为空")
    @Pattern(regexp = "^1[3,4,5,7,8][0-9]{9}$", message = "请填写正确的手机号")
    private String receiverPhone;

    @NotBlank(message = "收货人邮编不能为空")
    @Pattern(regexp = "^[0-9]{6}$", message = "请填写正确的邮编")
    private String receiverZip;

    @NotBlank(message = "收货人地址不能为空")
    private String receiverAddress;

    @NotNull(message = "发货方式必选")
    private Long delivery;

    public OrderShipping(Long orderShippingId, Long orderId, String receiverName, String receiverPhone, String receiverZip, String receiverAddress, Long delivery) {
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
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