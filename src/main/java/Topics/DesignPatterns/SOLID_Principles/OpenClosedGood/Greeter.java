package Topics.DesignPatterns.SOLID_Principles.OpenClosedGood;

public class Greeter {
    private IPersonality personality;

    public Greeter(IPersonality interfacePersonality) {
        this.personality = interfacePersonality;
    }

    public String greet() {
        return this.personality.greet();
    }
}
