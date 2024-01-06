package com.personal.weather.service;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.personal.weather.model.WeatherData;
import com.personal.weather.model.WeatherDataResult;
import com.personal.weather.view.WeatherDataView;

public class WeatherDataStorage {


	private ArrayList<WeatherData> dataEntries;
	private HashMap<String, ArrayList<WeatherData>> stateReadings;
	private WeatherDataView weatherView;

	public WeatherDataStorage(String fileName) throws FileNotFoundException {
		this.dataEntries = DataLoader.loadAllEntries(fileName);
		this.stateReadings = getStateReadings();
	}

	public WeatherDataResult findMaxTempReading() {

		int maxTemp = dataEntries.get(0).getMaxTemp();
		String maxState = dataEntries.get(0).getState();

		for (int i = 1; i < dataEntries.size(); i++) {
			int temp = dataEntries.get(i).getMaxTemp();
			if (temp > maxTemp) {
				maxTemp = temp;
				maxState = dataEntries.get(i).getState();
			}
		}
		return new WeatherDataResult(maxTemp, maxState);
	}

	public WeatherDataResult findMinTempReading() {
		int minTemp = dataEntries.get(0).getMinTemp();
		String minState = dataEntries.get(0).getState();


		for (int i = 0; i < dataEntries.size(); i++) {
			int temp = dataEntries.get(i).getMinTemp();
			if (temp < minTemp) {
				minTemp = temp;
				minState = dataEntries.get(i).getState();
			}
		}
		return new WeatherDataResult(minTemp, minState);
	}

	public WeatherDataResult findAverageTempReading() {
		int avgTemp = dataEntries.get(0).getAvgTemp();
		int sum = 0;
		
		for(int i = 0; i< dataEntries.size(); i++) {
			sum += dataEntries.get(i).getAvgTemp();			
		}
		avgTemp = sum/dataEntries.size();
		
		return new WeatherDataResult(avgTemp, null);
	}


	public ArrayList<String> findStatesByTemp(int temp) {
		ArrayList<String> statesList = new ArrayList<>();
		for(int i =0; i<dataEntries.size(); i++) {
			if(dataEntries.get(i).getMaxTemp() == temp || dataEntries.get(i).getMinTemp() == temp 
					|| dataEntries.get(i).getAvgTemp() == temp) {
				String state = dataEntries.get(i).getState();
				
				if(!statesList.contains(state)) {
					statesList.add(state);
				}
				
			}
		}
	
		return statesList;
	}
	
	public ArrayList<WeatherData> getEntries(){
		
		return dataEntries;
	}
	
	public int getNumberOfStates() {
//		ArrayList<String> statesList = new ArrayList<>();
//		
//		for(int i =0; i < dataEntries.size(); i++) {
//			if(!statesList.contains(dataEntries.get(i).getState())) {
//				statesList.add(dataEntries.get(i).getState());
//			}
//		}
//		int allStates  = statesList.size();
		
		
	   return stateReadings.keySet().size();
	}
	
	public String getWarmestCity() {
		int maxTemp = findMaxTempReading().getTemp();
		String warmestCity = dataEntries.get(0).getCity();
		for(WeatherData data : dataEntries) {
			if(data.getMaxTemp() == maxTemp) {
				warmestCity = data.getCity();
			}
		}			
		return warmestCity;
	}
	
	public String getColdestCity() {
		int minTemp = findMinTempReading().getTemp();
		String coldestCity = dataEntries.get(0).getCity();
		for(WeatherData data : dataEntries) {
			if(data.getMinTemp() == minTemp) {
				coldestCity = data.getCity();
			}
		}			
		return coldestCity;
	}
	
	
	// returning all of the weather data associated with this state
	public ArrayList<WeatherData> getTempByState(String state) {
		
	    
	    for(Map.Entry<String, ArrayList<WeatherData>> mapEntry : stateReadings.entrySet()) {
	    	
			String stateInfo = mapEntry.getKey();
			
			if(stateInfo.equals(state)) {
				return mapEntry.getValue();
			}
			
		}
		return null;
		
	}
	
	public HashMap<String, ArrayList<WeatherData>> getStateReadings(){
		HashMap<String, ArrayList<WeatherData>> stateReadings = new HashMap<>();
		for(WeatherData states : dataEntries) {
			if(stateReadings.containsKey(states.getState())) {
				ArrayList<WeatherData> stateValues = stateReadings.get(states.getState());
				stateValues.add(states);
				stateReadings.put(states.getState(), stateValues);
			}else {
				ArrayList<WeatherData> stateValues = new ArrayList<>();
				stateValues.add(states);
				stateReadings.put(states.getState(), stateValues);
			}
		}
		for(Map.Entry<String, ArrayList<WeatherData>> mapEntry : stateReadings.entrySet()) {
			String dataList = mapEntry.getKey();
			ArrayList<WeatherData> stateData = mapEntry.getValue();
			//weatherView.printMessage(dataList + "->" + stateData);
		}
		return stateReadings;
	}

}