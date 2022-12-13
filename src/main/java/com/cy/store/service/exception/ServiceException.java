package com.cy.store.service.exception;

/**
 * package com.cy.store.service.exception
 *
 * @author
 * @version v1.0
 * @data 2022/12/11 14:46
 */

/** 业务层异常的基类*/
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
