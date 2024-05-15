package com.undec.AppClima.output;

import com.undec.AppClima.domain.User;

public interface ILoginRepository {

    User searchUserByName(String nameUser);
}
