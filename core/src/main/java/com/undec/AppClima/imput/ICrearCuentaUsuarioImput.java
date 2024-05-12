package com.undec.AppClima.imput;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;

public interface ICrearCuentaUsuarioImput {
    boolean CrearUsuario(User usuario) throws ExceptionUserExist;
}
