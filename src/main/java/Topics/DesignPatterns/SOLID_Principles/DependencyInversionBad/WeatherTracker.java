package Topics.DesignPatterns.SOLID_Principles.DependencyInversionBad;

public class WeatherTracker {
    public String currentConditions;
    Phone phone;
    Emailer emailer;

    public WeatherTracker() {
        phone = new Phone();
        emailer = new Emailer();
    }

    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;

        if (weatherDescription.equals("rainy")) {
            String alert = phone.generateWeatherAlert(weatherDescription);
            System.out.println(alert);
        }
        if (weatherDescription.equals("sunny")) {
            String alert = emailer.generateWeatherAlert(weatherDescription);
            System.out.println(alert);
        }
    }
}
