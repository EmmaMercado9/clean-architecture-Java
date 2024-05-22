package com.undec.AppClima.usecaseUnitTest.UseCases;
import Mockito.MockitoExtension;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.output.IGetAllUsersRepository;
import com.undec.AppClima.usecases.GetAllUsersUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class GetAllUsersUnitTest {
    @Mock
    IGetAllUsersRepository iGetAllUsersRepository;
    @Test
    void consultUser_ExistUser_ReturnCollection(){
        GetAllUsersUseCase getAllUsersUseCase=new GetAllUsersUseCase(iGetAllUsersRepository);
        List<User> users= Arrays.asList(
                User.instance("Emmanuel","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina"),
                User.instance("Mateo1","mateo12@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina"),
                User.instance("Emmamercad","emamerca@gmail.com","Hola123*", LocalDate.of(2003,1,26),"Argentina")
        );
        when(iGetAllUsersRepository.getAll()).thenReturn(users);
        Collection<User> totalUsers=getAllUsersUseCase.getAllUsers();
        Assertions.assertEquals(3,totalUsers.size());
    }
    @Test
    void consultUser_ExistUser_ReturnEmptyCollection(){
        GetAllUsersUseCase getAllUsersUseCase=new GetAllUsersUseCase(iGetAllUsersRepository);
        when(iGetAllUsersRepository.getAll()).thenReturn(Collections.emptyList());
        Collection<User> totalUsers=getAllUsersUseCase.getAllUsers();
        Assertions.assertEquals(0,totalUsers.size());
    }
}