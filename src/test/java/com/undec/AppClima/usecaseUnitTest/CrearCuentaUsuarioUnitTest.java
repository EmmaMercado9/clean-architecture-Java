package com.undec.AppClima.usecaseUnitTest;

import Mockito.MockitoExtension;
import com.undec.AppClima.domain.Usuario;
import com.undec.AppClima.repository.ICrearCuentaUsuarioRepository;
import com.undec.AppClima.usecases.CrearCuentaUsuarioUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;


import java.sql.Date;
import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearCuentaUsuarioUnitTest {

    @Mock
    ICrearCuentaUsuarioRepository iCrearCuentaUsuarioRepository;

    @Test
    void CrearUsuario_UsuarioExiste_CrearUsuario(){

        Usuario usuario=Usuario.instance("Emmanuel","emamerca@gmail.com","ema123", LocalDate.of(2003,1,26),"Argentina");
        CrearCuentaUsuarioUseCase crearCuentaUsuarioUseCase=new CrearCuentaUsuarioUseCase(iCrearCuentaUsuarioRepository);
    }


}
