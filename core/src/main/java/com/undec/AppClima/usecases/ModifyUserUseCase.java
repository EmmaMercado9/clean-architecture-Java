package com.undec.AppClima.usecases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;
import com.undec.AppClima.imput.IModifyUserImput;
import com.undec.AppClima.output.IModifyUserRepository;

public class ModifyUserUseCase implements IModifyUserImput {
    IModifyUserRepository iModifyUserRepository;
    public ModifyUserUseCase(IModifyUserRepository iModifyUserRepository){
        this.iModifyUserRepository=iModifyUserRepository;
    }
    @Override
    public boolean ModifyUser(User userNuevo) {

        if(iModifyUserRepository.userMailExist(userNuevo.getMail())){
           throw new ExceptionUserExist("El mail ya existe ingrese otro");
        }
        else{
            return iModifyUserRepository.modifyUser(userNuevo.getName(), userNuevo.getPassword(), userNuevo.getMail());

        }

    }
}
