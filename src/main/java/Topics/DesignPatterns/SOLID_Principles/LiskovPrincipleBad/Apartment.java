package Topics.DesignPatterns.SOLID_Principles.LiskovPrincipleBad;

public abstract class Apartment {
    public int squareFootage;
    public int numberOfBedrooms;

    abstract void setSquareFootage(int sqft);
}
