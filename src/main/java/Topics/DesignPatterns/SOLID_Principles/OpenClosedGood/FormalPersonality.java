package Topics.DesignPatterns.SOLID_Principles.OpenClosedGood;

public class FormalPersonality implements IPersonality {
    @Override
    public String greet() {
        return "Good evening, sir";
    }
}
