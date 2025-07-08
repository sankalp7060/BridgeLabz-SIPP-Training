import java.util.ArrayList;
import java.util.List;

public class History {
    static class RentalRecord {
        String type;
        String model;
        int days;
        double rent;

        public RentalRecord(String type, String model, int days, double rent) {
            this.type = type;
            this.model = model;
            this.days = days;
            this.rent = rent;
        }
    }

    private List<RentalRecord> records = new ArrayList<>();

    public void addRecord(String type, String model, int days, double rent) {
        records.add(new RentalRecord(type, model, days, rent));
    }

    public void printHistory(String customerName, double totalRent) {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Your payment history:- ");
        for (RentalRecord record : records) {
            System.out.println("Vehicle rented: " + record.model +
                               ", Type: " + record.type +
                               ", Days: " + record.days +
                               ", Rent:- " + record.rent);
        }
        System.out.println("\nTotal Rent Bill for " + customerName + ":- " + totalRent);
        System.out.println("Thank you for using our Vehicle Rental");
    }
}
