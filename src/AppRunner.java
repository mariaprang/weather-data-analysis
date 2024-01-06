import java.io.FileNotFoundException;

import com.personal.weather.conroller.WeatherDataController;

public class AppRunner {

	public static void main(String[] args) throws FileNotFoundException {
		WeatherDataController controller = new WeatherDataController();
		controller.run();

	}

}
