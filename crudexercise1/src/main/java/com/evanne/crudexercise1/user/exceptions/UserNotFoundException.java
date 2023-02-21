package com.evanne.crudexercise1.user.exceptions;

public class UserNotFoundException extends Throwable{
    public UserNotFoundException(String message){
        super(message);
    }
}
