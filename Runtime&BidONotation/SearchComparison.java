public class SearchComparison {
    public static boolean linearSearch(int[] arr, int target) {
        for (int i : arr)
            if (i == target) return true;
        return false;
    }
    public static boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1, n2 = r - mid;
        int[] left = new int[n1], right = new int[n2];
        for (int i = 0; i < n1; i++) left[i] = arr[l + i];
        for (int i = 0; i < n2; i++) right[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};
        int target = -1;

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * size * 10);

            long start = System.nanoTime();
            linearSearch(arr, target);
            long linearTime = System.nanoTime() - start;

            int[] arrCopy = arr.clone();
            start = System.nanoTime();
            mergeSort(arrCopy, 0, arrCopy.length - 1);
            binarySearch(arrCopy, target);
            long binaryTime = System.nanoTime() - start;

            System.out.printf("N=%d | Linear: %d ms | Binary: %d ms\n",
                    size, linearTime / 1_000_000, binaryTime / 1_000_000);
        }
    }
}
