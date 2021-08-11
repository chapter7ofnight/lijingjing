package com.westone.lijingjing.exception;

public class UserNotFoundException extends LijingjingException {
    public UserNotFoundException(String username) {
        super(String.format("user not found|username=%s", username));
    }
}
