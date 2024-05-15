package com.undec.AppClima.usecaseUnitTest.UseCases;

import Mockito.MockitoExtension;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;
import com.undec.AppClima.imput.ICreateAccountUserImput;
import com.undec.AppClima.output.ICreateAccountUserReposytory;
import com.undec.AppClima.usecases.CreateUserAccountUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateUserAccountUnitTest {


    @Mock
    ICreateAccountUserReposytory iCreateAccountUserReposytory;



    @Test
    void CreateUserAccount_NoUserExists_CreateUserAccountCorrect(){
        User user= User.instance("Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        CreateUserAccountUseCase createUserAccountUseCase=new CreateUserAccountUseCase(iCreateAccountUserReposytory);
        when(iCreateAccountUserReposytory.UserExist("emamerca@gmail.com")).thenReturn(false);
        when(iCreateAccountUserReposytory.SaveUser(user)).thenReturn(true);
        boolean resultado= createUserAccountUseCase.CrearUsuario(user);
        Assertions.assertTrue(resultado);
    }
    @Test
    void CreateUserAccount_UserExists_CreateUserAccount() {

        User user= User.instance("Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        CreateUserAccountUseCase createUserAccountUseCase=new CreateUserAccountUseCase(iCreateAccountUserReposytory);
        when(iCreateAccountUserReposytory.UserExist("emamerca@gmail.com")).thenReturn(true);
        when(iCreateAccountUserReposytory.SaveUser(user)).thenReturn(false);
        Assertions.assertThrows(ExceptionUserExist.class,()->createUserAccountUseCase.CrearUsuario(user));
    }


}
