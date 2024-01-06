package com.personal.weather.service;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.personal.weather.model.WeatherData;

public class DataLoader {
	
	

	public static ArrayList<WeatherData> loadAllEntries(String fileName) throws FileNotFoundException {

		ArrayList<WeatherData> list = new ArrayList<>();
		Scanner fileScanner = new Scanner(new File(fileName));

		fileScanner.nextLine(); // skip one line for column names
		while (fileScanner.hasNext()) {
			String line = fileScanner.nextLine();
			String[] array = line.split(",");
			//System.out.println(Arrays.toString(array));
			
//			int index = 0;
//			for(String word : array) {
//				System.out.println("index: " + index +" -> " +  word);
//				index++;
//			}

			String city = formatString(array[5]);
			String state = formatString(array[9]);
			int avgTemp = Integer.parseInt(formatString(array[10]));
			int maxTemp = Integer.parseInt(formatString(array[11]));
			int minTemp = Integer.parseInt(formatString(array[12]));
			double windSpeed = Double.parseDouble(formatString(array[14]));

			WeatherData weaterData = new WeatherData(city, state, avgTemp, maxTemp, minTemp, windSpeed);
			list.add(weaterData);

		}
		fileScanner.close();
		return list;
	}
	
	private static String formatString(String value) {
		return value.replaceAll("\"", "");
	}

}