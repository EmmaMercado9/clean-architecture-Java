package com.undec.AppClima.rest.usecasesconfig;

import com.undec.AppClima.input.IQueryTemperatureInput;
import com.undec.AppClima.output.IQueryTemperatureRepository;
import com.undec.AppClima.usecases.QueryTemperatureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryTemperatureConfig {
    IQueryTemperatureRepository iQueryTemperatureRepository;
    @Bean
    public IQueryTemperatureInput iQueryTemperatureInput(IQueryTemperatureRepository  iQueryTemperatureRepository){
        return  new QueryTemperatureUseCase(iQueryTemperatureRepository);
    }
}
