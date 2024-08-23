package com.undec.AppClima.persistence;

import com.undec.AppClima.InfrastructureApplication;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.persistence.useCases.CreateAccountUserRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
@SpringBootTest(classes = InfrastructureApplication.class)
public class CreateAccountUserTest {

    @Autowired
    CreateAccountUserRepoImpl createAccountUserRepo;

    @Test
    void CreateAccountUser_CorrectSave(){
        User user= User.instance(1L,"Emmanuel","emamercad@gmail.com","Hola123*", LocalDate.of(2001,1,26),"Argentina");

        boolean resultado =createAccountUserRepo.SaveUser(user);
        Assertions.assertTrue(resultado);

    }
    @Test
    void CreateAccountUser_CorrectExistMail(){
        User user= User.instance(1L,"Emmanuel","emamercad@gmail.com","Hola123*", LocalDate.of(2001,1,26),"Argentina");

        boolean resultado =createAccountUserRepo.UserExist(user.getMail());
        Assertions.assertTrue(resultado);

    }

}
