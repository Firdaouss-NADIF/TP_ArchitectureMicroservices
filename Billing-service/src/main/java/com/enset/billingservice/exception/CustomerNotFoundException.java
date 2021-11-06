package com.enset.billingservice.exception;

public class CustomerNotFoundException extends Throwable {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
