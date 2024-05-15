package com.undec.AppClima.usecaseUnitTest.UseCases;

import Mockito.MockitoExtension;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;
import com.undec.AppClima.output.IModifyUserRepository;
import com.undec.AppClima.usecases.ModifyUserUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModifyUserUnitTest {


    @Mock
    IModifyUserRepository modifyUserRepository;



    @Test
    void ModifyUser_UserMailExists_ModifyUserAccountInCorrect(){
        User user= User.instance("Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        ModifyUserUseCase modifyUserUseCase=new ModifyUserUseCase(modifyUserRepository);
        when(modifyUserRepository.userMailExist(user.getMail())).thenReturn(true);
        when(modifyUserRepository.modifyUser(user.getName(),user.getPassword(),user.getMail())).thenReturn(false);

        Exception expecionEsperada=Assertions.assertThrows(ExceptionUserExist.class,()->modifyUserUseCase.ModifyUser(user));
        Assertions.assertEquals("El mail ya existe ingrese otro",expecionEsperada.getMessage());
    }

    @Test
    void ModifyUser_UserMailNoExists_ModifyUserAccountCorrect(){
        User user= User.instance("Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina");
        ModifyUserUseCase modifyUserUseCase=new ModifyUserUseCase(modifyUserRepository);
        when(modifyUserRepository.userMailExist(user.getMail())).thenReturn(false);
        when(modifyUserRepository.modifyUser(user.getName(), user.getPassword(), user.getMail())).thenReturn(true);

        boolean result=modifyUserUseCase.ModifyUser(user);
        Assertions.assertTrue(result);
    }
}
