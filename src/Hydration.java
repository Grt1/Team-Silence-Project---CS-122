public class Hydration {
    private String beverage;
    private double ounces;

    public Hydration(String beverage, double ounces) {
        this.beverage = beverage;
        this.ounces = ounces;
    }

    public String getBeverage() {
        return beverage;
    }

    public double getOunces() {
        return ounces;
    }

    @Override
    public String toString() {
        return beverage + ", " + ounces + " ounces";
    }
}
