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
