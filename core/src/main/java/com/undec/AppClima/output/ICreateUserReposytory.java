package com.undec.AppClima.output;

import com.undec.AppClima.domain.User;

public interface ICreateUserReposytory {

    boolean UserExist(String mail);

    boolean SaveUser(User user);
}
