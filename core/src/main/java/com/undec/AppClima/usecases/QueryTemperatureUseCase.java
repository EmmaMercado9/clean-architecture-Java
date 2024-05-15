package com.undec.AppClima.usecases;

import com.undec.AppClima.imput.IQueryTemperatureImput;
import com.undec.AppClima.output.IQueryTemperatureRepository;

public class QueryTemperatureUseCase implements IQueryTemperatureImput {

    IQueryTemperatureRepository iQueryTemperatureRepository;
    public QueryTemperatureUseCase(IQueryTemperatureRepository iQueryTemperatureRepository){
        this.iQueryTemperatureRepository=iQueryTemperatureRepository;
    }

    @Override
    public String QueryTemperature(String location) {
        return iQueryTemperatureRepository.QueryTemperaturebyLocation(location);
    }
}
