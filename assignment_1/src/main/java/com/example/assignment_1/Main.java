package com.example.assignment_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    private Label weatherLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather App");

        weatherLabel = new Label();
        Button weatherButton = new Button("Get Weather");
        weatherButton.setOnAction(e -> {
            try {
                WeatherData weatherData = WeatherAPI.getWeather("Brampton");
                String weatherInfo = String.format("City: %s\nTemperature: %.2f°C\nFeels Like: %.2f°C",
                        weatherData.getCityName(),
                        weatherData.getMain().getTemperature() - 273.15, // Convert to Celsius
                        weatherData.getMain().getFeelsLikeTemperature() - 273.15); // Convert to Celsius
                weatherLabel.setText(weatherInfo);
            } catch (IOException ex) {
                weatherLabel.setText("Failed to retrieve weather information. Please try again later.");
            }
        });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(weatherLabel, weatherButton);

        Scene scene = new Scene(vBox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
