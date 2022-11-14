package lessonCore7.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline {
    @JsonProperty("Text")
    private String text;
    @JsonProperty("EndDate")
    private String endDate;



    public Headline() { }

    public String getText() {
        return text;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Headline{" +
                "text='" + text + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
