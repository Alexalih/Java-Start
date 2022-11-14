package lessonCore7.project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import static lessonCore7.project.Period.FIVE_DAY;
import static lessonCore7.project.Period.NOW;

public class Controller {
    private WeatherModel  weatherModel = new AccuWeatherModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller(){
        variants.put(1, NOW);
        variants.put(5, FIVE_DAY);
    }

    public void getWeather(String inputTime, String inputCity) throws IOException {
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

}
