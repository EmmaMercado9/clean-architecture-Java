package com.undec.AppClima.output;

import com.undec.AppClima.domain.User;

import java.util.Collection;

public interface IGetAllUsersRepository {

    Collection<User> getAll();
}
