public class IceCreamRush {
    public static void bubbleSort(String[] flavors, int[] sales) {
        int n = sales.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (sales[j] < sales[j + 1]) {
                    // Swap sales
                    int tempSales = sales[j];
                    sales[j] = sales[j + 1];
                    sales[j + 1] = tempSales;
                    // Swap flavors
                    String tempFlavor = flavors[j];
                    flavors[j] = flavors[j + 1];
                    flavors[j + 1] = tempFlavor;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] flavors = {"Vanilla", "Chocolate", "Strawberry", "Mango", "Butterscotch", "Pineapple", "Coffee", "Blueberry"};
        int[] sales = {120, 200, 150, 180, 130, 100, 170, 90};

        bubbleSort(flavors, sales);
        System.out.println("Flavors sorted by popularity:");
        for (int i = 0; i < flavors.length; i++) {
            System.out.println(flavors[i] + ": " + sales[i] + " sales");
        }
    }
}
