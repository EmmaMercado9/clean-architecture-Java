package com.undec.AppClima.repository;

import com.undec.AppClima.domain.User;

public interface ICreateUserAccountRepository {

    boolean UsuarioExist(String mail);
    boolean SaveUserAccount(User user);

}
