package lessonCore6;


import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class Homework6 {
    public static void main(String[] args) throws IOException{
        OkHttpClient client = new OkHttpClient();


        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("/forecasts/v1/daily/5day/295212")
                .addQueryParameter("apikey", "M0sGZAUD12ZL2mtwth1yfonOxU9rZyvu")
                .build();


        Request request = new Request.Builder()
                .url(url)
                .addHeader("accept", "application/json")
                .get()
                .build();


        Response response =  client.newCall(request).execute();


        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
