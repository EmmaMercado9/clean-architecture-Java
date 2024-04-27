package com.undec.AppClima.usecases.imput;

import com.undec.AppClima.domain.Usuario;
import com.undec.AppClima.exeptions.ExceptionUsuarioExiste;

public interface ICrearCuentaUsuarioImput {
    boolean CrearUsuario(Usuario usuario) throws ExceptionUsuarioExiste;
}
