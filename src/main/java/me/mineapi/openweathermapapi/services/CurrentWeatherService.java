package me.mineapi.openweathermapapi.services;

import me.mineapi.openweathermapapi.utils.Units;
import me.mineapi.openweathermapapi.modules.CurrentWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrentWeatherService {
    @GET("data/2.5/weather")
    public Call<CurrentWeather> getCurrentWeatherFromZip(
            @Query("zip") int zip,
            @Query("appid") String appid,
            @Query("units") Units units
            );

    @GET("data/2.5/weather")
    public Call<CurrentWeather> getCurrentWeatherFromCityName(
            @Query("q") String cityName,
            @Query("appid") String appid,
            @Query("units") Units units
    );

    @GET("data/2.5/weather")
    public Call<CurrentWeather> getCurrentWeatherFromCityID(
            @Query("id") String cityID,
            @Query("appid") String appid,
            @Query("units") Units units
    );

    @GET("data/2.5/weather")
    public Call<CurrentWeather> getCurrentWeatherFromGeo(
            @Query("lat") float lat,
            @Query("lon") float lon,
            @Query("appid") String appid,
            @Query("units") Units units
    );
}
