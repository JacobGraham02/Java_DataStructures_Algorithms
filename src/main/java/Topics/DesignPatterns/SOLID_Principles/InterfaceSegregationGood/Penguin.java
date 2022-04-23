package Topics.DesignPatterns.SOLID_Principles.InterfaceSegregationGood;

public class Penguin implements ISwimmingCreature, IFeatheredCreature{
    public String currentLocation;
    public int numberOfFeathers;

    public Penguin(int initialFeatherCount) {
        this.numberOfFeathers = initialFeatherCount;
    }

    @Override
    public void molt() {
        this.numberOfFeathers -= 4;
    }

    @Override
    public void swim() {
        this.currentLocation = "Penguin is in the water";
    }
}
