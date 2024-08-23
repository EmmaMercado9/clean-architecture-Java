package com.undec.AppClima.usecaseUnitTest.UseCases;
import Mockito.MockitoExtension;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserIncorrect;
import com.undec.AppClima.output.IModifyUserRepository;
import com.undec.AppClima.usecases.ModifyUserUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ModifyUserUnitTest {
    @Mock
    IModifyUserRepository modifyUserRepository;

    @Test
    void ModifyUser_Mail_ModifyUserAccountCorrect() {
        User user = User.instance(1L,"Carlos", "carlosmerca@gmail.com", "Hola1234*", LocalDate.of(2003, 1, 26), "Argentina");
        User newUser = User.instance(2L,"Emmanuel", "emamerca@gmail.com", "Hola123*", LocalDate.of(2003, 1, 26), "Argentina");
        when(modifyUserRepository.get_Current_User(user.getIdUser())).thenReturn(user);
        ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(modifyUserRepository);
        when(modifyUserRepository.userMailExist("emamerca@gmail.com")).thenReturn(false);
        when(modifyUserRepository.modifyUser(user, user.getIdUser())).thenReturn(true);
        boolean result = modifyUserUseCase.ModifyUser(null,null,"emamerca@gmail.com", user.getIdUser());
        Assertions.assertTrue(result);
    }
    @Test
    void ModifyUser_Name_ModifyUserAccountCorrect() {
        User user = User.instance(1L,"Carlos", "carlosmerca@gmail.com", "Hola1234*", LocalDate.of(2003, 1, 26), "Argentina");
        when(modifyUserRepository.get_Current_User(user.getIdUser())).thenReturn(user);
        ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(modifyUserRepository);
        when(modifyUserRepository.userNameExist("Emmanuel")).thenReturn(false);
        when(modifyUserRepository.modifyUser(user, user.getIdUser())).thenReturn(true);
        boolean result = modifyUserUseCase.ModifyUser("Emmanuel",null,null, user.getIdUser());
        Assertions.assertTrue(result);
    }
    @Test
    void ModifyPassword_ModifyUserAccountCorrect() {
        User user = User.instance(1L,"Carlos", "carlosmerca@gmail.com", "Hola1234*", LocalDate.of(2003, 1, 26), "Argentina");
        when(modifyUserRepository.get_Current_User(user.getIdUser())).thenReturn(user);
        ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(modifyUserRepository);
        when(modifyUserRepository.modifyUser(user, user.getIdUser())).thenReturn(true);
        boolean result = modifyUserUseCase.ModifyUser(null,"Hola1234*",null, user.getIdUser());
        Assertions.assertTrue(result);
    }
    @Test
    void ModifyPassword_ModifyUserAccountInCorrect() {
        User user = User.instance(1L,"Carlos", "carlosmerca@gmail.com", "Hola1234*", LocalDate.of(2003, 1, 26), "Argentina");
        when(modifyUserRepository.get_Current_User(user.getIdUser())).thenReturn(user);
        ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(modifyUserRepository);
        when(modifyUserRepository.modifyUser(user, user.getIdUser())).thenReturn(true);
        Exception result = Assertions.assertThrows(ExceptionUserIncorrect.class,()->modifyUserUseCase.ModifyUser(null,"hola1234",null, user.getIdUser()));
        Assertions.assertEquals("La contraseña no es valida!!",result.getMessage());
    }
}