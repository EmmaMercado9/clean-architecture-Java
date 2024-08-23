package com.undec.AppClima.usecaseUnitTest.UseCases;
import Mockito.MockitoExtension;
import com.undec.AppClima.exeptions.User.ExceptionTemperatureLocationNoExist;
import com.undec.AppClima.output.IQueryTemperatureRepository;
import com.undec.AppClima.usecases.QueryTemperatureUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class QueryTemperatureUnitTest {
    @Mock
    IQueryTemperatureRepository iQueryTemperatureRepository;
    @Test
    void testQueryTemperature_LocationExists_ReturnTemperature(){
        QueryTemperatureUseCase queryTemperatureUseCase=new QueryTemperatureUseCase(iQueryTemperatureRepository);
        String location="New York";
        float temperature=20.0f;
        when(iQueryTemperatureRepository.locationExist(location)).thenReturn(true);
        when(iQueryTemperatureRepository.QueryTemperatureByLocation(location)).thenReturn(temperature);
        float result=queryTemperatureUseCase.QueryTemperature(location);
        Assertions.assertEquals(temperature,result);
    }
    @Test
    void testQueryTemperature_LocationNoExists_ExceptionTemperatureLocationNoExist(){
        QueryTemperatureUseCase queryTemperatureUseCase=new QueryTemperatureUseCase(iQueryTemperatureRepository);
        String location="Noexisto";
        when(iQueryTemperatureRepository.locationExist(location)).thenReturn(false);
        Exception exceptionResult= Assertions.assertThrows(ExceptionTemperatureLocationNoExist.class,()->queryTemperatureUseCase.QueryTemperature(location));
        Assertions.assertEquals("Por favor Ingrese una ubicación válida!!!",exceptionResult.getMessage());
    }
}