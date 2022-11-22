package lessonCore7.project;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherModel {

    public void getWeather( String city, Period period) throws IOException, SQLException;
    public void getAllSavedData() throws IOException;

}
