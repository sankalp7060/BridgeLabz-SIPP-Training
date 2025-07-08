public abstract class Vehicle implements Rental {
    protected String model;
    protected double basePrice;

    public Vehicle(String model, double basePrice) {
        this.model = model;
        this.basePrice = basePrice;
    }

    public String getModel() {
        return model;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
