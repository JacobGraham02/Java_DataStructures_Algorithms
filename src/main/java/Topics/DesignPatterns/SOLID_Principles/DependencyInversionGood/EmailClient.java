package Topics.DesignPatterns.SOLID_Principles.DependencyInversionGood;

public class EmailClient implements INotifier {
    @Override
    public String alertWeatherConditions(String weatherCondition) {
        return "It is: " + weatherCondition;
    }
}
