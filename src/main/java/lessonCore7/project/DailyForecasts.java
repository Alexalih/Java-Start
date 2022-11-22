package lessonCore7.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecasts {
    @JsonProperty("Temperature")
    private Temperature temperature;
    @JsonProperty("Date")
    private String data;

    @JsonProperty("Day")
    private Day day;

    public Day getDay() {
        return day;
    }
    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "DailyForecasts{" +
                "temperature=" + temperature +
                '}';
    }

    public String getData() {
        return data;
    }
}
