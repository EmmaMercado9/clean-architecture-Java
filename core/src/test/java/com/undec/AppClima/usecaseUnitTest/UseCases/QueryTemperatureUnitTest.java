package com.undec.AppClima.usecaseUnitTest.UseCases;

import Mockito.MockitoExtension;
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
        String temperature="20°C";

        when(iQueryTemperatureRepository.QueryTemperaturebyLocation(location)).thenReturn(temperature);

        String result=queryTemperatureUseCase.QueryTemperature(location);
        Assertions.assertEquals(temperature,result);
    }


    @Test
    void testQueryTemperature_LocationNoExists_ReturnTemperatureNull(){
        QueryTemperatureUseCase queryTemperatureUseCase=new QueryTemperatureUseCase(iQueryTemperatureRepository);
        String location="Noexisto";

        when(iQueryTemperatureRepository.QueryTemperaturebyLocation(location)).thenReturn(null);

        String result=queryTemperatureUseCase.QueryTemperature(location);
        Assertions.assertNull(result);
    }
}
