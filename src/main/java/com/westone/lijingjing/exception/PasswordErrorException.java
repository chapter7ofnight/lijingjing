package com.westone.lijingjing.exception;

public class PasswordErrorException extends LijingjingException {
    public PasswordErrorException(String username) {
        super(String.format("password is not correct|username=%s", username));
    }
}
