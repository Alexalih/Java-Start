package lessonCore7.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    @JsonProperty("Headline")
    private Headline headline;
    @JsonProperty("DailyForecasts")
    private ArrayList <DailyForecasts> dailyForecasts;


    public Weather() {}

    public Headline getHeadline() {
        return headline;
    }

    public ArrayList<DailyForecasts> getDailyForecasts() {
        return dailyForecasts;
    }

    @Override
    public String toString() {
        return "WeatherOneDay{" +
                "headline=" + headline +
                ", dailyForecasts=" + dailyForecasts +
                '}';
    }
}
