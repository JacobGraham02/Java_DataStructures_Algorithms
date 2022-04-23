package Topics.DesignPatterns.SOLID_Principles.DependencyInversionBad;

public class Emailer {

    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}
