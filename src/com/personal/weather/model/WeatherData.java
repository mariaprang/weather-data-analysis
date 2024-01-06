package com.personal.weather.model;

public class WeatherData {

	private String city;
	private String state;
	private int avgTemp;
	private int maxTemp;
	private int minTemp;
	private double windSpeed;

	public WeatherData(String city, String state, int avgTemp, int maxTemp, int minTemp, double windSpeed) {
		this.city = city;
		this.state = state;
		this.avgTemp = avgTemp;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.windSpeed = windSpeed;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAvgTemp() {
		return avgTemp;
	}

	public void setAvgTemp(int avgTemp) {
		this.avgTemp = avgTemp;
	}

	public int getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}

	public int getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	@Override
	public String toString() {
		return "City: " + city + ", State: " + state + ", AvgTemp: " + avgTemp + ", MaxTemp: " + maxTemp
				+ ", MinTemp: " + minTemp + ", WindSpeed: " + windSpeed + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		WeatherData dataToCompareWith = ((WeatherData) obj);
		
		if(this.city.equals(dataToCompareWith.city) && this.state.equals(dataToCompareWith.state)
				&& this.minTemp == dataToCompareWith.minTemp && this.maxTemp == dataToCompareWith.maxTemp
				&& this.avgTemp == dataToCompareWith.avgTemp) {
			return true;
		}
		else {
			return false;
		}
		
	}

}