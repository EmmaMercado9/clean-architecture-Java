package com.undec.AppClima.output;

import com.undec.AppClima.domain.User;

public interface IModifyUserRepository {

    boolean userMailExist(String mail);
    boolean modifyUser(String name,String password,String email);

}
