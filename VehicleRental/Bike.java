public class Bike extends Vehicle {
    public Bike(String model) {
        super(model, 500);
    }

    @Override
    public double calculateRent(int numberOfDays) {
        return basePrice * numberOfDays;
    }
}
