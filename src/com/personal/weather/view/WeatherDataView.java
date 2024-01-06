package com.personal.weather.view;

import java.util.Scanner;

public class WeatherDataView {
	
	
	private Scanner inputScanner;
	
	public WeatherDataView() {
		this.inputScanner = new Scanner(System.in);
	}
	
	public void printMenu() {
		System.out.println("--- WEATHER ANALYSIS MENU ---");
		System.out.println("Press 1 to GET ALL WEATHER STATS");
		System.out.println("Press 2 to GET WEATHER STATS FOR MAX TEMPERATURE");
		System.out.println("Press 3 to GET WEATHER STATS FOR MIN TEMPERATURE");
		System.out.println("Press 4 to GET WEATHER STATS FOR AVG TEMPERATURE");
		System.out.println("Press 5 to GET WEATHER STATES BY TEMPERATURE");
		System.out.println("Press 6 to GET NUMBER of STATES IN THE REPORT");
		System.out.println("Press 7 to GET THE WARMEST CITY BY STATE");
		System.out.println("Press 8 to GET THE COLDEST CITY BY STATE");
		System.out.println("Press 9 to GET THE TEMPERATURE READINGS BY STATE");
		System.out.println("Press 10 to QUIT");
		System.out.println("--- END OF MENU ---");
	}
	
	public int getIntegerInput(String message) {
		System.out.println(message);
		return inputScanner.nextInt();
	}
	
	public String getStringInput(String message) {
		System.out.println(message);

		String userInput = inputScanner.nextLine();
		while (userInput.isEmpty() || userInput.isBlank()) {
			userInput = inputScanner.nextLine();
		}

		return userInput;

	}
	
	public double getDoubleInput(String message) {
		System.out.println(message);
		return inputScanner.nextDouble();
	}
	
	public void printMessage(String message) {
		System.out.println("-----");
		System.out.println(message);
		System.out.println("-----");
	}
	
	
	public void printMessageFormatted(String message) {
		System.out.println(message);
	}
	
	public void printSeparator() {
		System.out.println("-----");
	}
	
	public void printError(String message) {
		System.out.println("Error: "+message);
		
	}

}