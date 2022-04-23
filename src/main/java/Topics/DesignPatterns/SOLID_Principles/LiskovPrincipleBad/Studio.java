package Topics.DesignPatterns.SOLID_Principles.LiskovPrincipleBad;

public class Studio extends Apartment {

    public Studio() {
        this.numberOfBedrooms = 0;
    }

    @Override
    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }
}
