package com.personal.weather.tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.personal.weather.model.WeatherData;
import com.personal.weather.model.WeatherDataResult;
import com.personal.weather.service.WeatherDataStorage;


public class WeatherDataUnitTest {
	
	private static final String FILE_NAME = "test.csv";
	
	private static WeatherDataStorage weatherDataStorage;
	
	@BeforeClass
	public static void setup() throws FileNotFoundException {
		weatherDataStorage = new WeatherDataStorage(FILE_NAME);		
	}
	
	@Test
	public void testFindMaxTemp() {		
		WeatherDataResult expectedResult = new WeatherDataResult(80, "Hawaii");
		WeatherDataResult actualResult = weatherDataStorage.findMaxTempReading();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testFindMinTemp() {
		WeatherDataResult expectedResult = new WeatherDataResult(-7, "Nevada");
		WeatherDataResult actualResult = weatherDataStorage.findMinTempReading();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void findAverageTempReading() {
		WeatherDataResult expectedResult = new WeatherDataResult(40, null);
		WeatherDataResult actualResult = weatherDataStorage.findAverageTempReading();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testFindStatesByTemp() {
		List<String> expectedResult = Arrays.asList("Nevada");
		ArrayList<String> actualResult = weatherDataStorage.findStatesByTemp(-7);
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetNumberOfStates() {
		int expectedResult = 12;
		int actualResult = weatherDataStorage.getNumberOfStates();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetWarmestCity() {
		String expectedResult = "Kahului";
		String actualResult = weatherDataStorage.getWarmestCity();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetColdestCity() {
		String expectedResult = "Eureka";
		String actualResult = weatherDataStorage.getColdestCity();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetTempByState() {
		ArrayList<WeatherData> actualResult = weatherDataStorage.getTempByState("Texas");
		WeatherData expectedData = new WeatherData("San Antonio", "Texas", 47, 52, 41, 6.2);
		WeatherData actualData = actualResult.get(0);
		Assert.assertEquals(expectedData, actualData);
	}
	
//	@Test
//	public void testGetStateReadings() {
//		HashMap<String, ArrayList<WeatherData>> expectedResult = new HashMap<>();
//		HashMap<String, ArrayList<WeatherData>> actualResult = weatherDataStorage.getStateReadings();
//		Assert.assertEquals(expectedResult, actualResult.toString());
//	}
}
