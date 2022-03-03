package com.thor.mongoplus.exception;

/**
 * @author: lingjun.jlj
 * @date: 2022/3/3 23:15
 * @description: mongo-plus 自定义异常
 */
public class MongoPlusException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MongoPlusException(String message) {
        super(message);
    }

    public MongoPlusException(Throwable throwable) {
        super(throwable);
    }

    public MongoPlusException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
