public class QuickSortAlgo {
    public static void main(String[] args) {
        int arr[] = { 8, 14, 32, 0, 45, 22 };

        System.out.println("Given Array");
        printArray(arr);

        QuickSortAlgo ob = new QuickSortAlgo();
        ob.QuickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    private static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public int partition(int arr[], int low, int high) {
        int pivot = low, i = low, j = high;
        while (i < j) {
            while (arr[i] < arr[pivot])
                i++;
            while (arr[j] > arr[pivot])
                j--;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = temp;

        return j;
    }

    public void QuickSort(int arr[], int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            QuickSort(arr, low, p - 1);
            QuickSort(arr, p + 1, high);
        }
    }
}
