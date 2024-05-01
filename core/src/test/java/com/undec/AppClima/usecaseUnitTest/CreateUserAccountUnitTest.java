package com.undec.AppClima.usecaseUnitTest;

import Mockito.MockitoExtension;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUser;
import com.undec.AppClima.repository.ICreateUserAccountRepository;
import com.undec.AppClima.usecases.CreateUserAccountUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;


import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CreateUserAccountUnitTest {

    @Mock
    ICreateUserAccountRepository iCreateUserAccountRepository;

    @Test
    void CreateUserAccount_UserExists_CreateUserAccount() throws ExceptionUser {

        User user= User.instance("Emmanuel","emamerca@gmail.com","ema123", LocalDate.of(2003,1,26),"Argentina");
        CreateUserAccountUseCase createUserAccountUseCase =new CreateUserAccountUseCase(iCreateUserAccountRepository);

        when(iCreateUserAccountRepository.UsuarioExist("emamerca@gmail.com")).thenReturn(true);


        Assertions.assertThrows(ExceptionUser.class,()->createUserAccountUseCase.CrearUsuario(user));


    }

    @Test
    void CreateUserAccount_NoUserExists_CreateUserAccount() throws ExceptionUser {

        User user= User.instance("Emmanuel","emamerca@gmail.com","ema123", LocalDate.of(2003,1,26),"Argentina");
        CreateUserAccountUseCase createUserAccountUseCase=new CreateUserAccountUseCase(iCreateUserAccountRepository);

        when(iCreateUserAccountRepository.UsuarioExist("emamerca@gmail.com")).thenReturn(false);
        when(iCreateUserAccountRepository.SaveUserAccount(user)).thenReturn(true);

        boolean result=createUserAccountUseCase.CrearUsuario(user);

        Assertions.assertTrue(result);


    }



}
