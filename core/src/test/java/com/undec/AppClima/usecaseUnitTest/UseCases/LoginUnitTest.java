package com.undec.AppClima.usecaseUnitTest.UseCases;


import Mockito.MockitoExtension;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionInvalidLogin;
import com.undec.AppClima.output.ILoginRepository;
import com.undec.AppClima.usecases.LoginUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginUnitTest {

    @Mock
    ILoginRepository iLoginRepository;


    @Test
    void ValidateLogin_UserExist_LoginCorrect(){
        LoginUseCase loginUseCase=new LoginUseCase(iLoginRepository);
        User user= User.instance("Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");

        when(iLoginRepository.searchUserByName("Emmanuel")).thenReturn(user);

        boolean result=loginUseCase.LoginUser("Emmanuel","Hola123*");
        Assertions.assertTrue(result);

    }

    @Test
    void ValidateLogin_UserNameNoExist_ExceptionInvalidLogin(){
        LoginUseCase loginUseCase=new LoginUseCase(iLoginRepository);

        when(iLoginRepository.searchUserByName("Emmanuel")).thenReturn(null);
        Exception userNull=Assertions.assertThrows(ExceptionInvalidLogin.class,()->loginUseCase.LoginUser("Emmanuel","Hola123*"));
        Assertions.assertEquals("Ingrese credenciales válidas!!",userNull.getMessage());

    }

    @Test
    void ValidateLogin_PasswordNoMatch_ExceptionInvalidLogin(){
        LoginUseCase loginUseCase=new LoginUseCase(iLoginRepository);
        User user= User.instance("Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");

        when(iLoginRepository.searchUserByName("Emmanuel")).thenReturn(user);
        Exception passwordNoMatch=Assertions.assertThrows(ExceptionInvalidLogin.class,()->loginUseCase.LoginUser("Emmanuel","Hola123**"));
        Assertions.assertEquals("Ingrese credenciales válidas!!",passwordNoMatch.getMessage());

    }
}
