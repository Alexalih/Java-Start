package lessonCore7.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TempValue {
    @JsonProperty("Value")
    private String value;
    @JsonProperty("Unit")
    private String unit;

    public String getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "TempValue{" +
                "Value='" + value + '\'' +
                ", Unit='" + unit + '\'' +
                '}';
    }

}
