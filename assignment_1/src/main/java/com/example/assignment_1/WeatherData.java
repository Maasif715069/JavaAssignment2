package com.example.assignment_1;

public class WeatherData {
    public MainData main;
    private String name;

    public MainData getMain() {
        return main;
    }

    public String getCityName() {
        return name;
    }

    public static class MainData {
        private double temp;
        private double feels_like;

        public double getTemperature() {
            return temp;
        }

        public double getFeelsLikeTemperature() {
            return feels_like;
        }
    }
}
