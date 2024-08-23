package com.undec.AppClima.output;
public interface IQueryTemperatureRepository {
    float QueryTemperatureByLocation(String location);
    boolean locationExist(String location);
}