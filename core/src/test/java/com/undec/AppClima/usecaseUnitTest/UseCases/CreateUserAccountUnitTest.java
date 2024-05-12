package com.undec.AppClima.usecaseUnitTest.UseCases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;
import com.undec.AppClima.usecases.CreateUserAccountUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;




public class CreateUserAccountUnitTest {

    CreateUserAccountUseCase createUserAccountUseCase;

    @Test
    void CreateUserAccount_UserExists_CreateUserAccount() throws ExceptionUserExist {

      //  User user= User.instance("Emmanuel","emamerca@gmail.com","ema123", LocalDate.of(2003,1,26),"Argentina");



        //Assertions.assertThrows(ExceptionUserExist.class,()->createUserAccountUseCase.CrearUsuario(user));


    }

    @Test
    void CreateUserAccount_NoUserExists_CreateUserAccount() throws ExceptionUserExist {

        //User user= User.instance("Emmanuel","emamerca@gmail.com","ema123", LocalDate.of(2003,1,26),"Argentina");


        //boolean result=createUserAccountUseCase.CrearUsuario(user);

        //Assertions.assertTrue(result);


    }



}
