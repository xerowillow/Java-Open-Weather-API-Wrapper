import me.mineapi.openweathermapapi.modules.CurrentWeather;
import me.mineapi.openweathermapapi.utils.Units;

public class Sample {
    public static void main(String[] args) {
        OpenWeatherMapAPI api = new OpenWeatherMapAPI("YOUR API KEY HERE");
        CurrentWeather weather = api.getCurrentWeather(10001, Units.imperial);

        System.out.println(weather.getMain().getTemp());
    }
}
