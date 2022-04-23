package Topics.DesignPatterns.SOLID_Principles.DependencyInversionGood;

public class WeatherTracker {
    public String currentConditions;
    public INotifier weatherNotifier;

    public WeatherTracker(INotifier iNotifier) {
        this.weatherNotifier = iNotifier;
    }

    public String setCurrentConditions(String weatherDescription) {
        return this.weatherNotifier.alertWeatherConditions(weatherDescription);
    }
}
