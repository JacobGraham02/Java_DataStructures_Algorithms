package Topics.DesignPatterns.SOLID_Principles.LiskovPrincipleBad;

public class PenthouseSuite extends Apartment {
    public PenthouseSuite() {
        this.numberOfBedrooms = 4;
    }

    @Override
    void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }
}
