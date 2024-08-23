package com.undec.AppClima.input;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionModifyUserIncorrect;
public interface IModifyUserInput {
    boolean ModifyUser(String name,String pass,String mail,Long idCurrentUser);
}