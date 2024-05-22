package com.undec.AppClima.exeptions.User;
public class ExceptionTemperatureLocationNoExist extends  RuntimeException{
    public ExceptionTemperatureLocationNoExist (String smg){
        super(smg);
    }
}