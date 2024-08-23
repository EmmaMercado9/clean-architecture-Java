package com.undec.AppClima.persistence.useCases;

import com.undec.AppClima.output.IQueryTemperatureRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class QueryTemperatureRepoImpl implements IQueryTemperatureRepository {

    private static final String API_KEY = "os2ukrlirgr0om5xspjs6lgfw4rs7eqd91ln8j50"; // Reemplaza con tu clave de API de OpenWeatherMap
    private static final String API_URL = "https://www.meteosource.com/es/client";

    @Override
    public float QueryTemperatureByLocation(String location) {
        float temperature = 0.0f;

        try {
            // Construir la URL con el endpoint y los parámetros
            String urlString = API_URL + "?q=" + location + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar la solicitud
            connection.setRequestMethod("GET");

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Procesar la respuesta JSON
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject main = jsonResponse.getJSONObject("main");
            temperature = (float) main.getDouble("temp"); // Obtiene la temperatura en grados Celsius

        } catch (Exception e) {
            e.printStackTrace();
        }

        return temperature;
    }

    @Override
    public boolean locationExist(String location) {
        try {
            // Construir la URL para verificar la existencia de la ubicación
            String urlString = API_URL + "?q=" + location + "&appid=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar la solicitud
            connection.setRequestMethod("GET");

            // Leer el código de respuesta
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}