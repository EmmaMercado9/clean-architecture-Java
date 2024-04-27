package com.undec.AppClima.usecaseUnitTest;

import Mockito.MockitoExtension;
import com.undec.AppClima.domain.Usuario;
import com.undec.AppClima.exeptions.ExceptionUsuarioExiste;
import com.undec.AppClima.repository.ICrearCuentaUsuarioRepository;
import com.undec.AppClima.usecases.CrearCuentaUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
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

        when(iCrearCuentaUsuarioRepository.ExisteUsuario("emamerca@gmail.com")).thenReturn(true);


        Assertions.assertThrows(ExceptionUsuarioExiste.class,()->crearCuentaUsuarioUseCase.CrearUsuario(usuario));


    }

    @Test
    void CrearUsuario_UsuarioNoExiste_CrearUsuario() throws ExceptionUsuarioExiste {

        Usuario usuario=Usuario.instance("Emmanuel","emamerca@gmail.com","ema123", LocalDate.of(2003,1,26),"Argentina");
        CrearCuentaUsuarioUseCase crearCuentaUsuarioUseCase=new CrearCuentaUsuarioUseCase(iCrearCuentaUsuarioRepository);

        when(iCrearCuentaUsuarioRepository.ExisteUsuario("emamerca@gmail.com")).thenReturn(false);
        when(iCrearCuentaUsuarioRepository.GuardarUsuario(usuario)).thenReturn(true);

        boolean resultado=crearCuentaUsuarioUseCase.CrearUsuario(usuario);

        Assertions.assertTrue(resultado);


    }



}
