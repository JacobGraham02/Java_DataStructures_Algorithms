package Topics.DesignPatterns.SOLID_Principles.InterfaceSegregationBad;

public class Penguin implements IBird {
    public String currentLocation;
    public int numberOfFeathers;

    public Penguin(int initialFeatherCount) {
        this.numberOfFeathers = initialFeatherCount;
    }

    public void swim() {
        this.currentLocation = "Penguin is in the water";
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly.");
    }

    @Override
    public void molt() {
        this.numberOfFeathers -= 1;
    }
}
