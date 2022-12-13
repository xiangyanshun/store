package com.cy.store.service.exception;

/**
 * package com.cy.store.service.exception
 *
 * @author
 * @version v1.0
 * @data 2022/12/11 14:47
 */
public class insertException extends ServiceException {
    public insertException() {
        super();
    }

    public insertException(String message) {
        super(message);
    }

    public insertException(String message, Throwable cause) {
        super(message, cause);
    }

    public insertException(Throwable cause) {
        super(cause);
    }

    protected insertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
