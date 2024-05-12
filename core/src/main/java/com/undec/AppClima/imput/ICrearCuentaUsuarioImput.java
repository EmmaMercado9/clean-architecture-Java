package com.undec.AppClima.usecases.imput;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUser;

public interface ICrearCuentaUsuarioImput {
    boolean CrearUsuario(User usuario) throws ExceptionUser;
}
