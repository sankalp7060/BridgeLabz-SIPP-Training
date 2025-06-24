public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double RATE_PER_DAY = 50.0;

    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * RATE_PER_DAY;
    }
}
