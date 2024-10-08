package com.undec.AppClima.usecaseUnitTest.model;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserIncomplete;
import com.undec.AppClima.exeptions.User.ExceptionUserIncorrect;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserUnitTest {
    @Test
    void instance_AllAttributes_InstanceCorrect() throws ExceptionUserIncomplete, ExceptionUserIncorrect {
        User user = User.instance(1L,"Emmanuel","emamerc@gmail.com","Hola1234*",LocalDate.of(2003,1,21),"Argentina");
        assertNotNull(user);
    }
    @Test
    void instance_missingName_UserIncompleteException() {
        Exception exceptionNull = assertThrows(ExceptionUserIncomplete.class, () -> User.instance(2L,null,"emamerc@gmail.com","Hola1234*",LocalDate.of(2003,1,21),"Argentina"));
        Exception exceptionEmpty = assertThrows(ExceptionUserIncomplete.class, () -> User.instance(1L,"","emamerc@gmail.com","Hola1234*",LocalDate.of(2003,1,21),"Argentina"));
        assertEquals("El nombre usuario debe ser cargado!!", exceptionNull.getMessage());
        assertEquals("El nombre usuario debe ser cargado!!", exceptionEmpty.getMessage());
    }
    @Test
    void instance_missingMail_UserIncompleteException() {
        Exception exceptionNull = assertThrows(ExceptionUserIncomplete.class, () -> User.instance(1L,"Emmanuel",null,"Hola1234*",LocalDate.of(2003,1,21),"Argentina"));
        Exception exceptionEmpty = assertThrows(ExceptionUserIncomplete.class, () -> User.instance(1L,"Emmanuel","","Hola1234*",LocalDate.of(2003,1,21),"Argentina"));
        assertEquals("El correo electronico debe ser cargado!!", exceptionNull.getMessage());
        assertEquals("El correo electronico debe ser cargado!!", exceptionEmpty.getMessage());
    }
    @Test
    void instance_missingPassword_UserIncompleteException() {
        Exception exceptionNull = assertThrows(ExceptionUserIncomplete.class, () -> User.instance(1L,"Emmanuel","emamerc@gmail.com",null,LocalDate.of(2003,1,21),"Argentina"));
        Exception exceptionEmpty = assertThrows(ExceptionUserIncomplete.class, () -> User.instance(1L,"Emmanuel","emamerc@gmail.com","",LocalDate.of(2003,1,21),"Argentina"));
        assertEquals("La contraseña debe ser cargada!!", exceptionNull.getMessage());
        assertEquals("La contraseña debe ser cargada!!", exceptionEmpty.getMessage());
    }
    @Test
    void instance_CountryLong_UserIncorrectException() {
        Exception exceptionNull = assertThrows(ExceptionUserIncorrect.class, () -> User.instance(1L,"Emmanuel","emamerc@gmail.com","Hola1234*",LocalDate.of(2003,1,21),"Argentinaholabuenosdiasbuenasnochescomomestamotodobien"));
        assertEquals("Longitud Pais no valida", exceptionNull.getMessage());
    }
}