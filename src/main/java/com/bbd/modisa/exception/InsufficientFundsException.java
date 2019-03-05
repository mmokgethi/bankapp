package com.bbd.modisa.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message)
    {
        super(message);
    }
}
