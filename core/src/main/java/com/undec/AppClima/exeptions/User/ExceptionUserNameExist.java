package com.undec.AppClima.exeptions.User;
public class ExceptionUserNameExist extends RuntimeException{
    public ExceptionUserNameExist(String msg){
        super(msg);
    }
}