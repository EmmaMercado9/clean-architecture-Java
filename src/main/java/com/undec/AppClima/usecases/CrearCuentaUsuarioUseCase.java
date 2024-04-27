package com.undec.AppClima.usecases;

import com.undec.AppClima.domain.Usuario;
import com.undec.AppClima.repository.ICrearCuentaUsuarioRepository;
import com.undec.AppClima.usecases.imput.ICrearCuentaUsuarioImput;

public class CrearCuentaUsuarioUseCase implements ICrearCuentaUsuarioImput {

    ICrearCuentaUsuarioRepository iCrearCuentaUsuarioRepository;

    public CrearCuentaUsuarioUseCase(ICrearCuentaUsuarioRepository iCrearCuentaUsuarioRepository) {
    }


    @Override
    public boolean CrearUsuario(Usuario usuario) {
        return false;
    }
}
