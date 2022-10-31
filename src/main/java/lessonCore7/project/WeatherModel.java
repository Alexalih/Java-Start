package lessonCore7.project;

import java.io.IOException;

public interface WeatherModel {

    public void getWeather( String city, Period period) throws IOException;

}
