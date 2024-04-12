package com.example.assignment_1;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPI {
    private static final String API_KEY = "862e2d438b4580f492654aa09d290b24";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    public static WeatherData getWeather(String city) throws IOException {
        String apiUrl = String.format(API_URL, city, API_KEY);
        URL url = new URL(apiUrl);
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine());
        }
        scanner.close();

        Gson gson = new Gson();
        return gson.fromJson(stringBuilder.toString(), WeatherData.class);
    }
}
