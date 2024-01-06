package com.personal.weather.conroller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.personal.weather.model.WeatherData;
import com.personal.weather.model.WeatherDataResult;
import com.personal.weather.service.WeatherDataStorage;
import com.personal.weather.view.WeatherDataView;

public class WeatherDataController {
	
	private static final String FILE_NAME = "weather.csv";


	private WeatherDataView weatherView;
	private WeatherDataStorage weatherStorage;

	public WeatherDataController() throws FileNotFoundException {
		this.weatherView = new WeatherDataView();
		this.weatherStorage = new WeatherDataStorage(FILE_NAME);
	}

	public void run() {
		while (true) {
			weatherView.printMenu();

			int userChoice = weatherView.getIntegerInput("");

			if (userChoice == 1) {
				getAllWeather();
			} else if (userChoice == 2) {
				findMaxTemp();
			} else if (userChoice == 3) {
				findMinTemp();
			} else if (userChoice == 4) {
				findAvgTemp();
			} else if (userChoice == 5) {
				getStatesByTemp();
			} else if (userChoice == 6) {
				getNumberOfStates();
			} else if (userChoice == 7) {
				getWarmest();
			} else if (userChoice == 8) {
				getColdest();
			} else if (userChoice == 9) {
				getTempReading();
			} else if (userChoice == 10) {
				break;
			} else {
				weatherView.printError("Invalid Input");
			}
		}
	}

	public void getAllWeather() {
		ArrayList<WeatherData> allData = weatherStorage.getEntries();
		for(WeatherData data : allData) {
			weatherView.printMessageFormatted(data.toString());
		}
		weatherView.printSeparator();
	}

	public void findMaxTemp() {
		WeatherDataResult data = weatherStorage.findMaxTempReading();
		weatherView.printMessage("Maximum Temperature by the all stats: " + data.getTemp() +" in " + data.getState());
	}

	public void findMinTemp() {
		int minTemp = weatherStorage.findMinTempReading().getTemp();
		weatherView.printMessage("Minimum Temperature by the all stats: " + minTemp);
	}

	public void findAvgTemp() {
		int avgTemp = weatherStorage.findAverageTempReading().getTemp();
		weatherView.printMessage("Average Temperature by the all stats: " + avgTemp);
	}

	public void getStatesByTemp() {
		int userInputTemp = weatherView.getIntegerInput("Type temperature: ");
		ArrayList<String> statesList = weatherStorage.findStatesByTemp(userInputTemp);
		weatherView.printMessage("All the states by the temperature you choose: " + statesList);
	}

	public void getNumberOfStates() {
		int numberOfStates = weatherStorage.getNumberOfStates();
		weatherView.printMessage("The number of states in the report: " + numberOfStates);
	}

	public void getWarmest() {
		String warmestCity = weatherStorage.getWarmestCity();
		weatherView.printMessage(warmestCity);
	}

	public void getColdest() {
		String coldestCity = weatherStorage.getColdestCity();
		weatherView.printMessage(coldestCity);
	}

	public void getTempReading() {
		weatherView.printMessage("Type state you want to check temperature: ");
		String userInputState = weatherView.getStringInput("");
		ArrayList<WeatherData> temps = weatherStorage.getTempByState(userInputState);
		for(WeatherData data : temps) {
			weatherView.printMessageFormatted(data.toString());
		}
		weatherView.printSeparator();

	}
}