package Topics.DesignPatterns.SOLID_Principles.LiskovPrincipleGood;

public class UnitUpgrader {
    private PenthouseSuite penthouseSuite;

    public UnitUpgrader(PenthouseSuite penthouseSuite) {
        this.penthouseSuite = penthouseSuite;
    }

    public void upgradeApartmentSquareFootageBy40() {
        penthouseSuite.squareFootage += 40;
    }

    public void upgradeApartmentBedroomAmountBy1() {
        penthouseSuite.numberOfBedrooms += 1;
    }
}
