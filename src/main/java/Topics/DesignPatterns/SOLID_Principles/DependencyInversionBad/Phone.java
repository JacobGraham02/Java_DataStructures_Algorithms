package Topics.DesignPatterns.SOLID_Principles.DependencyInversionBad;

public class Phone {

    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}
