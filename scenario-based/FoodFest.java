public class FoodFest {
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];

        for (int i = 0; i < left.length; i++) left[i] = arr[l + i];
        for (int i = 0; i < right.length; i++) right[i] = arr[m + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] zone1 = {100, 150, 200};   // sorted
        int[] zone2 = {80, 130, 220};    // sorted
        int[] master = new int[zone1.length + zone2.length];

        System.arraycopy(zone1, 0, master, 0, zone1.length);
        System.arraycopy(zone2, 0, master, zone1.length, zone2.length);

        mergeSort(master, 0, master.length - 1);

        System.out.println("Combined footfall (sorted):");
        for (int count : master) {
            System.out.print(count + " ");
        }
    }
}
