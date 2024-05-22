package com.undec.AppClima.usecases;
import com.undec.AppClima.exeptions.User.ExceptionTemperatureLocationNoExist;
import com.undec.AppClima.input.IQueryTemperatureInput;
import com.undec.AppClima.output.IQueryTemperatureRepository;
public class QueryTemperatureUseCase implements IQueryTemperatureInput {
    IQueryTemperatureRepository iQueryTemperatureRepository;
    public QueryTemperatureUseCase(IQueryTemperatureRepository iQueryTemperatureRepository){
        this.iQueryTemperatureRepository=iQueryTemperatureRepository;
    }
    @Override
    public float QueryTemperature(String location) {
        if(!iQueryTemperatureRepository.locationExist(location)){
            throw new ExceptionTemperatureLocationNoExist("Por favor Ingrese una ubicación válida!!!");
        }
        return iQueryTemperatureRepository.QueryTemperatureByLocation(location);
    }
}