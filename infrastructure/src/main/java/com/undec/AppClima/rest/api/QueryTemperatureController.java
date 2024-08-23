package com.undec.AppClima.rest.api;

import com.undec.AppClima.input.IQueryTemperatureInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clima")
public class QueryTemperatureController {
    IQueryTemperatureInput iQueryTemperatureInput;
    public  QueryTemperatureController(IQueryTemperatureInput iQueryTemperatureInput){
        this.iQueryTemperatureInput=iQueryTemperatureInput;
    }

    @GetMapping
    public ResponseEntity<?> queryTemperature(@RequestParam String location) {
        try {
            float temperature = iQueryTemperatureInput.QueryTemperature(location);
            return new ResponseEntity<>(temperature, HttpStatus.OK);
        } catch (Exception e) {
            // Manejo de errores
            return new ResponseEntity<>("Error al consultar la temperatura", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
