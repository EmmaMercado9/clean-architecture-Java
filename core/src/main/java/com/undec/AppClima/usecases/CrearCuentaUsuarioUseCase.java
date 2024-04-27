package com.undec.AppClima.usecases;

import com.undec.AppClima.domain.Usuario;
import com.undec.AppClima.exeptions.ExceptionUsuarioExiste;
import com.undec.AppClima.repository.ICrearCuentaUsuarioRepository;
import com.undec.AppClima.usecases.imput.ICrearCuentaUsuarioImput;

public class CrearCuentaUsuarioUseCase implements ICrearCuentaUsuarioImput {

    ICrearCuentaUsuarioRepository iCrearCuentaUsuarioRepository;

    public CrearCuentaUsuarioUseCase(ICrearCuentaUsuarioRepository iCrearCuentaUsuarioRepository) {
    }


    @Override
    public boolean CrearUsuario(Usuario usuario) throws ExceptionUsuarioExiste {
        if(iCrearCuentaUsuarioRepository.ExisteUsuario(usuario.getMail())){

            throw new ExceptionUsuarioExiste();
        }
        else{
            return iCrearCuentaUsuarioRepository.GuardarUsuario(usuario);
        }
    }
}
