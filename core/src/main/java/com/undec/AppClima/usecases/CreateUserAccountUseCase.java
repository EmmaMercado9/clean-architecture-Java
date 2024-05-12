package com.undec.AppClima.usecases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;
import com.undec.AppClima.imput.ICrearCuentaUsuarioImput;
import com.undec.AppClima.output.ICreateUserReposytory;

public class CreateUserAccountUseCase implements ICrearCuentaUsuarioImput {

    ICreateUserReposytory iCreateUserReposytory;

    public CreateUserAccountUseCase(ICreateUserReposytory iCreateUserReposytory){
        this.iCreateUserReposytory=iCreateUserReposytory;
    }

    @Override
    public boolean CrearUsuario(User user) throws ExceptionUserExist {

        if(iCreateUserReposytory.UserExist(user.getMail())){
            throw new ExceptionUserExist("El usuario ya existe");
        }
        else {
            return iCreateUserReposytory.SaveUser(user);
        }
    }
}
