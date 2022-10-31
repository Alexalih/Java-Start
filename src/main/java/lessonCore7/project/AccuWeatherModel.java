package lessonCore7.project;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;


public class AccuWeatherModel implements WeatherModel {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "M0sGZAUD12ZL2mtwth1yfonOxU9rZyvu";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Override
    public void getWeather(String city, Period period) throws IOException {
        if (getCityLocation(city)[0] == null) {
            System.out.println("Город не найден, попробуйте еще раз!");
            return;
        }
        String locationKey = getCityLocation(city)[0];
        String cityName = getCityLocation(city)[1];
        switch (period) {
            case NOW:
                HttpUrl url = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(locationKey)
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter("metric", "true")
                        .addQueryParameter("language", "ru")
                        .build();

                Request request = new Request.Builder()
                        .url(url)
                        .build();

                Response oneDayResponse = OK_HTTP_CLIENT.newCall(request).execute();
                String weatherResponse = oneDayResponse.body().string();

                Weather weatherOneDay = OBJECT_MAPPER.readValue(weatherResponse, Weather.class);

                String text = weatherOneDay.getHeadline().getText();
                String min = weatherOneDay.getDailyForecasts().get(0).getTemperature().getMinimum().getValue();
                String max = weatherOneDay.getDailyForecasts().get(0).getTemperature().getMaximum().getValue();
                String unit = weatherOneDay.getDailyForecasts().get(0).getTemperature().getMaximum().getUnit();

                System.out.printf("В городе %s  -  %s" + "\n" + "Температура воздуха от %s до %s %s.%n", cityName, text, min, max, unit);
                break;

            case FIVE_DAY:
                url = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(locationKey)
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter("metric", "true")
                        .addQueryParameter("language", "ru")
                        .build();

                request = new Request.Builder()
                        .url(url)
                        .build();

                Response fiveDayResponse = OK_HTTP_CLIENT.newCall(request).execute();
                weatherResponse = fiveDayResponse.body().string();
                Weather weatherFiveDay = OBJECT_MAPPER.readValue(weatherResponse, Weather.class);

                List<DailyForecasts> days = weatherFiveDay.getDailyForecasts();
                unit = weatherFiveDay.getDailyForecasts().get(0).getTemperature().getMaximum().getUnit();

                System.out.printf("Погода в  городе %s на 5 дней:%n", cityName);

                for (int i = 0; i < days.size(); i++) {
                    String date = weatherFiveDay.getDailyForecasts().get(i).getData().substring(0, 10);
                    min = weatherFiveDay.getDailyForecasts().get(i).getTemperature().getMinimum().getValue();
                    max = weatherFiveDay.getDailyForecasts().get(i).getTemperature().getMaximum().getValue();
                    System.out.printf("%s: от %s  до %s %s%n", date, min, max, unit);
                }
                break;
        }

    }

    private String[] getCityLocation(String city) throws IOException {
        String[] cityMap = new String[2];
        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", city)
                .addQueryParameter("language", "ru")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("accept", "application/json")
                .build();

        Response response = OK_HTTP_CLIENT.newCall(request).execute();
        String responseString = response.body().string();

        JsonNode json = OBJECT_MAPPER.readTree(responseString);

        if (!(json.get(0) ==null)) {
            String cityKey = json.get(0).at("/Key").asText();
            String cityName = json.get(0).at("/LocalizedName").asText();
            cityMap[0] = cityKey;
            cityMap[1] = cityName;
        }
        return cityMap;

    }
}


