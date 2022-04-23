package Topics.DesignPatterns.SOLID_Principles.OpenClosedGood;

public class CasualPersonality implements IPersonality{
    @Override
    public String greet() {
        return "What's up?";
    }
}
