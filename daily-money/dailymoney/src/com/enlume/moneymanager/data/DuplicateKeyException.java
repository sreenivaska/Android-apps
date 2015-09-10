package com.enlume.moneymanager.data;
/**
 * a entity record is duplicated
 *
 */
public class DuplicateKeyException extends Exception {

    private static final long serialVersionUID = 1L;

    public DuplicateKeyException() {
        super();
    }

    public DuplicateKeyException(String detailMessage) {
        super(detailMessage);
    }
}
