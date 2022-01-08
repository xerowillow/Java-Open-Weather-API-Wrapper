package me.mineapi.openweathermapapi;

import me.mineapi.openweathermapapi.modules.CurrentWeather;
import me.mineapi.openweathermapapi.services.CurrentWeatherService;
import me.mineapi.openweathermapapi.utils.Units;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class OpenWeatherMapAPI {
    private final String auth;
    private final Retrofit  retrofit;
    /***
     *
     * @param auth Open Weather Map API key.
     */
    public OpenWeatherMapAPI(String auth) {
        this.auth = auth;

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }
    /***
     *
     * @param zipCode Zip code
     * @param units Unit of measurement the API will use.
     * @return Current weather from the API.
     */
    public CurrentWeather getCurrentWeather(int zipCode, Units units) {
        CurrentWeather returnValue = null; //Establish the return value.

        CurrentWeatherService service = retrofit.create(CurrentWeatherService.class); //Create the weather service.
        Call<CurrentWeather> callSync = service.getCurrentWeatherFromZip(zipCode, auth, units); //Create a call to retrieve data from the API.

        try {
            Response<CurrentWeather> response = callSync.execute(); //Create a response and call the API.
            returnValue = response.body(); //Set the return value to the data from the response.
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnValue;
    }
    /***
     *
     * @param cityName City name, state code and country code divided by comma, Please, refer to ISO 3166 for the state codes or country codes.
     * @param units Unit of measurement the API will use.
     * @return Current weather from the API.
     */
    public CurrentWeather getCurrentWeather(String cityName, Units units) {
        CurrentWeather returnValue = null; //Establish the return value.

        CurrentWeatherService service = retrofit.create(CurrentWeatherService.class); //Create the weather service.
        Call<CurrentWeather> callSync = service.getCurrentWeatherFromCityName(cityName, auth, units); //Create a call to retrieve data from the API.

        try {
            Response<CurrentWeather> response = callSync.execute(); //Create a response and call the API.
            returnValue = response.body(); //Set the return value to the data from the response.
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnValue;
    }
    /***
     *
     * @param lon Geographical coordinates (longitude)
     * @param lat Geographical coordinates (latitude)
     * @param units Unit of measurement the API will use.
     * @return Current weather from the API.
     */
    public CurrentWeather getCurrentWeather(float lat, float lon, Units units) {
        CurrentWeather returnValue = null; //Establish the return value.

        CurrentWeatherService service = retrofit.create(CurrentWeatherService.class); //Create the weather service.
        Call<CurrentWeather> callSync = service.getCurrentWeatherFromGeo(lat, lon, auth, units); //Create a call to retrieve data from the API.

        try {
            Response<CurrentWeather> response = callSync.execute(); //Create a response and call the API.
            returnValue = response.body(); //Set the return value to the data from the response.
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnValue;
    }
}
