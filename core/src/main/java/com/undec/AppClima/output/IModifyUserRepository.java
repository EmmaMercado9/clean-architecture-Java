package com.undec.AppClima.output;
import com.undec.AppClima.domain.User;
public interface IModifyUserRepository {
    boolean userMailExist(String mail);
    boolean userNameExist(String userName);
    User get_Current_User(int idCurrentUser);
    boolean modifyUser(User user,int idCurrentUser);
}