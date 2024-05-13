package com.undec.AppClima.usecaseUnitTest.UseCases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;
import com.undec.AppClima.imput.ICreateAccountUserImput;
import com.undec.AppClima.output.ICreateAccountUserReposytory;
import com.undec.AppClima.usecases.CreateUserAccountUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;


public class CreateUserAccountUnitTest {

    ICreateAccountUserImput iCreateAccountUserImput;
    @Mock
    ICreateAccountUserReposytory iCreateAccountUserReposytory;

    @BeforeEach
    void  setup(){
        iCreateAccountUserImput=new CreateUserAccountUseCase(iCreateAccountUserReposytory);
    }

    @Test
    void CreateUserAccount_UserExists_CreateUserAccountCorrect(){
        User user= User.instance("Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        when(iCreateAccountUserReposytory.UserExist("emamerca@gmail.com")).thenReturn(false);
        when(iCreateAccountUserReposytory.SaveUser(user)).thenReturn(true);
        boolean resultado=iCreateAccountUserImput.CrearUsuario(user);
        Assertions.assertTrue(resultado);
    }
    @Test
    void CreateUserAccount_NoUserExists_CreateUserAccount() {

        User user= User.instance("Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        when(iCreateAccountUserReposytory.UserExist("emamerca@gmail.com")).thenReturn(true);
        when(iCreateAccountUserReposytory.SaveUser(user)).thenReturn(false);
        Assertions.assertThrows(ExceptionUserExist.class,()->iCreateAccountUserImput.CrearUsuario(user));
    }



}
