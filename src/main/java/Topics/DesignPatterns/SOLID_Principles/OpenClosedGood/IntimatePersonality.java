package Topics.DesignPatterns.SOLID_Principles.OpenClosedGood;

public class IntimatePersonality implements IPersonality {
    @Override
    public String greet() {
        return "Hello darling";
    }
}
