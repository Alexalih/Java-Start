package lessonCore7.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty("Minimum")
    private TempValue minimum;

    @JsonProperty("Maximum")
    private TempValue maximum;

    public TempValue getMinimum() {
        return minimum;
    }

    public TempValue getMaximum() {
        return maximum;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "minimum=" + minimum +
                ", Maximum=" + maximum +
                '}';
    }
}
