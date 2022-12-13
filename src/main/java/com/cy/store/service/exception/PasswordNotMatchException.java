package com.cy.store.service.exception;

/**
 * package com.cy.store.service.exception
 *
 * @author
 * @version v1.0
 * @data 2022/12/12 9:39
 */
public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException() {
        super();
    }
    
    public PasswordNotMatchException(String message) {
        super(message);
    }
    
    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }
    
    protected PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
