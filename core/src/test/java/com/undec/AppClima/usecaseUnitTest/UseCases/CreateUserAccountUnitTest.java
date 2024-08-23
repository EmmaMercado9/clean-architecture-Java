package com.undec.AppClima.usecaseUnitTest.UseCases;
import Mockito.MockitoExtension;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;
import com.undec.AppClima.exeptions.User.ExceptionUserNameExist;
import com.undec.AppClima.output.ICreateAccountUserRepository;
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
    ICreateAccountUserRepository iCreateAccountUserRepository;
    @Test
    void CreateUserAccount_NoUserExists_CreateUserAccountCorrect(){
        User user= User.instance(1L,"Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        CreateUserAccountUseCase createUserAccountUseCase=new CreateUserAccountUseCase(iCreateAccountUserRepository);
        when(iCreateAccountUserRepository.UserExist("emamerca@gmail.com")).thenReturn(false);
        when(iCreateAccountUserRepository.SaveUser(user)).thenReturn(true);
        boolean result= createUserAccountUseCase.createUser(user);
        Assertions.assertTrue(result);
    }
    @Test
    void CreateUserAccount_UserExists_CreateUserAccount() {
        User user= User.instance(1L,"Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        CreateUserAccountUseCase createUserAccountUseCase=new CreateUserAccountUseCase(iCreateAccountUserRepository);
        when(iCreateAccountUserRepository.UserExist(user.getMail())).thenReturn(true);
        when(iCreateAccountUserRepository.SaveUser(user)).thenReturn(false);
        Assertions.assertThrows(ExceptionUserExist.class,()->createUserAccountUseCase.createUser(user));
    }
    @Test
    void CreateUserAccount_userNameExists_CreateUserAccount() {
        User user= User.instance(1L,"Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        CreateUserAccountUseCase createUserAccountUseCase=new CreateUserAccountUseCase(iCreateAccountUserRepository);
        when(iCreateAccountUserRepository.userNameExist(user.getName())).thenReturn(true);
        when(iCreateAccountUserRepository.SaveUser(user)).thenReturn(false);
        Exception exceptionUserNameExist =Assertions.assertThrows(ExceptionUserNameExist.class,()->createUserAccountUseCase.createUser(user));
        Assertions.assertEquals("El nombre de Usuario ingresado ya existe, Ingrese otro!!!",exceptionUserNameExist.getMessage());
    }
    @Test
    void CreateUserAccount_UserMailAndUserNameNotExist_Success(){
        User user= User.instance(1L,"Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        CreateUserAccountUseCase createUserAccountUseCase=new CreateUserAccountUseCase(iCreateAccountUserRepository);
        when(iCreateAccountUserRepository.userNameExist(user.getName())).thenReturn(false);
        when(iCreateAccountUserRepository.UserExist(user.getMail())).thenReturn(false);
        when(iCreateAccountUserRepository.SaveUser(user)).thenReturn(true);
        Assertions.assertDoesNotThrow(()->createUserAccountUseCase.createUser(user));
    }
    @Test
    void CreateUserAccount_UserMailAndUserNameExist_Success(){
        User user= User.instance(1L,"Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        CreateUserAccountUseCase createUserAccountUseCase=new CreateUserAccountUseCase(iCreateAccountUserRepository);
        when(iCreateAccountUserRepository.UserExist(user.getMail())).thenReturn(true);
        when(iCreateAccountUserRepository.userNameExist(user.getName())).thenReturn(true);
        Exception resulMail=Assertions.assertThrows(ExceptionUserExist.class,()->createUserAccountUseCase.createUser(user));
        Assertions.assertEquals("El usuario ya existe",resulMail.getMessage());
        when(iCreateAccountUserRepository.UserExist(user.getMail())).thenReturn(false);
        Exception resulName=Assertions.assertThrows(ExceptionUserNameExist.class,()->createUserAccountUseCase.createUser(user));
        Assertions.assertEquals("El nombre de Usuario ingresado ya existe, Ingrese otro!!!",resulName.getMessage());
    }
}