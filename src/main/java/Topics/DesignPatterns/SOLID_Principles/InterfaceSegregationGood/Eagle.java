package Topics.DesignPatterns.SOLID_Principles.InterfaceSegregationGood;

public class Eagle implements IFlyingCreature, IFeatheredCreature{
    public String currentLocation;
    public int numberOfFeathers;

    public Eagle(int initialNumberOfFeathers) {
        this.numberOfFeathers = initialNumberOfFeathers;
    }

    @Override
    public void molt() {
        this.numberOfFeathers -= 1;
    }

    @Override
    public void fly() {
        this.currentLocation = "Eagle is in the air flying";
    }
}
