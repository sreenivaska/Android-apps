package com.enlume.moneymanager.data;

/**
 * no entity instance
 *
 */
public class NoInstanceException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoInstanceException() {
        super();
    }

    public NoInstanceException(String detailMessage) {
        super(detailMessage);
    }
}
