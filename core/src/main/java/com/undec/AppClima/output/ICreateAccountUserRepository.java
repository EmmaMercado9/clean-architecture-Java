package com.undec.AppClima.output;
import com.undec.AppClima.domain.User;
public interface ICreateAccountUserRepository {
    boolean UserExist(String mail);
    boolean userNameExist(String userName);
    boolean SaveUser(User user);
}