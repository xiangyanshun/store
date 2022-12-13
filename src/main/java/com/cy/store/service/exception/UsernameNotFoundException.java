package com.cy.store.service.exception;

/**
 * package com.cy.store.service.exception
 *
 * @author
 * @version v1.0
 * @data 2022/12/12 9:42
 */
public class UsernameNotFoundException extends ServiceException{
    public UsernameNotFoundException() {
        super();
    }
    
    public UsernameNotFoundException(String message) {
        super(message);
    }
    
    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public UsernameNotFoundException(Throwable cause) {
        super(cause);
    }
    
    protected UsernameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
