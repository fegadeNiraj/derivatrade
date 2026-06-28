package com.capitalmarkets.derivatrade.common.exception;

import lombok.Getter;

@Getter
public class DuplicateResourceFoundException extends RuntimeException{

    private final String errorCode;

    public DuplicateResourceFoundException(String errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
    }

}
