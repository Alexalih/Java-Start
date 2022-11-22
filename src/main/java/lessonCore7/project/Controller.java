package lessonCore7.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static lessonCore7.project.Period.*;

public class Controller {
    private WeatherModel  weatherModel = new AccuWeatherModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller(){
        variants.put(1, NOW);
        variants.put(5, FIVE_DAY);
    }

    public void getWeather(String inputTime, String inputCity) throws IOException, SQLException {
        Integer command = Integer.parseInt(inputTime);

        switch (variants.get(command)){
            case NOW:
                weatherModel.getWeather(inputCity, NOW);
                break;
            case FIVE_DAY:
                weatherModel.getWeather(inputCity, FIVE_DAY);
                break;

        }
    }

    public void getDatafromDB() throws IOException {
        weatherModel.getAllSavedData();
    }
}
