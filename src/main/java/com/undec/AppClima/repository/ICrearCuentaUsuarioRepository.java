package com.undec.AppClima.repository;

import com.undec.AppClima.domain.Usuario;

public interface ICrearCuentaUsuarioRepository {

    boolean ExisteUsuario(String mail);
    boolean GuardarUsuario(Usuario usuario);

}
