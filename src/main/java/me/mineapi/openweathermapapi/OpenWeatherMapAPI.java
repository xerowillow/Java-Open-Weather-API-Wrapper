/*
Copyright (C) 2022 MineAPI

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

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
