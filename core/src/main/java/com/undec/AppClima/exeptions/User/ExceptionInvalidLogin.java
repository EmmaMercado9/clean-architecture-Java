package com.undec.AppClima.exeptions.User;
public class ExceptionInvalidLogin extends RuntimeException{
    public ExceptionInvalidLogin (String msg){
        super(msg);
    }
}