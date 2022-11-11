import java.util.*;

class Searching {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of array:");
        int n = scan.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements in sorted manner:");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Enter the target to find");
        int target = scan.nextInt();

        int loc = BinarySearch(arr, target, 0, n - 1);
        if (loc != -1)
            System.out.println("Found at index " + loc);
        else
            System.out.println("Not found");

        scan.close();
    }

    private static int BinarySearch(int[] arr, int item, int low, int high) {
        if (low == high) {
            if (arr[low] == item)
                return low;
            else
                return -1;
        } else {
            int mid = low + (high - low) / 2;
            if (arr[mid] == item)
                return mid;
            else if (arr[mid] > item)
                return BinarySearch(arr, item, low, mid - 1);
            else
                return BinarySearch(arr, item, mid + 1, high);
        }
    }
}