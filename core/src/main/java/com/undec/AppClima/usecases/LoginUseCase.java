package com.undec.AppClima.usecases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionInvalidLogin;
import com.undec.AppClima.imput.ILoginImput;
import com.undec.AppClima.output.ILoginRepository;

public class LoginUseCase implements ILoginImput {

    ILoginRepository iLoginRepository;

    public LoginUseCase(ILoginRepository iLoginRepository){
        this.iLoginRepository=iLoginRepository;
    }
    @Override
    public boolean LoginUser(String nameUser, String password) {
        User user=iLoginRepository.searchUserByName(nameUser);
        if(user!=null && user.getPassword().equals(password)){
            return true;
        }
        else{
            throw new ExceptionInvalidLogin("Ingrese credenciales válidas!!");
        }
    }
}
