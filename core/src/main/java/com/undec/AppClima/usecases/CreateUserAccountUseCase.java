package com.undec.AppClima.usecases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUser;
import com.undec.AppClima.repository.ICreateUserAccountRepository;
import com.undec.AppClima.usecases.imput.ICrearCuentaUsuarioImput;

public class CreateUserAccountUseCase implements ICrearCuentaUsuarioImput {

    ICreateUserAccountRepository iCrearCuentaUsuarioRepository;

    public CreateUserAccountUseCase(ICreateUserAccountRepository iCrearCuentaUsuarioRepository) {
    }


    @Override
    public boolean CrearUsuario(User user) throws ExceptionUser {
        if(iCrearCuentaUsuarioRepository.UsuarioExist(user.getMail())){

            throw new ExceptionUser("Inicie Session o Ingrese un Correo diferente");
        }
        else{
            return iCrearCuentaUsuarioRepository.SaveUserAccount(user);
        }
    }
}
