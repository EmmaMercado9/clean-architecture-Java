package com.undec.AppClima.usecases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;
import com.undec.AppClima.imput.ICreateAccountUserImput;
import com.undec.AppClima.output.ICreateAccountUserReposytory;

public class CreateUserAccountUseCase implements ICreateAccountUserImput {

    ICreateAccountUserReposytory iCreateAccountUserReposytory;

    public CreateUserAccountUseCase(ICreateAccountUserReposytory iCreateAccountUserReposytory){
        this.iCreateAccountUserReposytory = iCreateAccountUserReposytory;
    }

    @Override
    public boolean CrearUsuario(User user) throws ExceptionUserExist {

        if(iCreateAccountUserReposytory.UserExist(user.getMail())){
            throw new ExceptionUserExist("El usuario ya existe");
        }
        else {
            return iCreateAccountUserReposytory.SaveUser(user);
        }
    }
}
