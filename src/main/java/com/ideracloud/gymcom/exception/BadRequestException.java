package com.ideracloud.gymcom.exception;

import org.springframework.validation.BindingResult;

public class BadRequestException extends RuntimeException {
    BindingResult result;

    public BadRequestException(BindingResult result, String message) {
        super(message);
        this.result = result;
    }

    public BadRequestException(String message) {
        super(message);
        this.result = this.result;
    }
}
