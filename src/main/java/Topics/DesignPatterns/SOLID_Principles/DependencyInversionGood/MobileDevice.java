package Topics.DesignPatterns.SOLID_Principles.DependencyInversionGood;

public class MobileDevice implements INotifier{
    @Override
    public String alertWeatherConditions(String weatherConditions) {
        return "It is: " + weatherConditions;
    }
}
