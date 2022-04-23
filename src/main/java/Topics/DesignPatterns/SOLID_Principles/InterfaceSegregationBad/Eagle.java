package Topics.DesignPatterns.SOLID_Principles.InterfaceSegregationBad;

public class Eagle implements IBird {
    public String currentLocation;
    public int numberOfFeathers;

    public Eagle(int initialFeatherCount) {
        this.numberOfFeathers = initialFeatherCount;
    }

    public void fly() {
        this.currentLocation = "In the air flying";
    }

    public void molt() {
        this.numberOfFeathers -= 1;
    }

}
