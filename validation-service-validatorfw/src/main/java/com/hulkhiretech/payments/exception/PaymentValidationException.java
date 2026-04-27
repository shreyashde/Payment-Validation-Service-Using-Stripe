package com.hulkhiretech.payments.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Exception thrown by the Stripe provider integration to represent errors with
 * an error code, message, and an associated HTTP status.
 */
@Getter
@Setter
@ToString(callSuper = true)

public class PaymentValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    public PaymentValidationException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
    
    public PaymentValidationException(String code, String message,
            HttpStatus httpStatus, Throwable cause) {
super(message, cause);
this.code = code;
this.message = message;
this.httpStatus = httpStatus;
}

}
