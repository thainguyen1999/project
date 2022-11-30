package services;

import com.google.gson.Gson;
import entities.entities.Current;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherSv {
    private final static  String current_weather_api="https://api.openweathermap.org/data/2.5/weather?q=Hanoi,vietnam&appid=09a71427c59d38d6a34f89b47d75975c&units=metric";
    public static String fetchContent(String url) throws IOException {
        final int OK =200;
        URL url1=new URL(url);
        HttpURLConnection connection=(HttpURLConnection)url1.openConnection();
        if (connection.getResponseCode()==OK){
            BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response=new StringBuffer();
            while ((inputLine=in.readLine())!=null){
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }
        return null;
    }
    public static Current getCurrent(){
        try {
            String rs=fetchContent(current_weather_api);
            Gson gson=new Gson();
            return gson.fromJson(rs, Current.class);
        }catch (Exception e){
            return null;
        }
    }

}
