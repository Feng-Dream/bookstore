package com.zking.bookstore.exception;

/**
 * 系统自定义运行时异常类，针对运行时异常，需要在程序中抛出此类的异常
 */
public class CustomRuntimeException extends RuntimeException {

    static final long serialVersionUID = -6687516993124229948L;

    //异常信息
    private String message;

    public CustomRuntimeException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
