import java.util.*;

public class Swap {
    static int a, b, c;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        a = scan.nextInt();
        System.out.print("Enter a number: ");
        b = scan.nextInt();
        System.out.print("Enter a number: ");
        c = scan.nextInt();
        printNumbers(a, b, c);
        int temp[] = swap(a, b);
        a = temp[0];
        b = temp[1];
        temp = swap(a, c);
        a = temp[0];
        c = temp[1];
        printNumbers(a, b, c);
        scan.close();

    }

    private static int[] swap(int x, int y) {
        x = x + y;
        y = x - y;
        x = x - y;
        return new int[] { x, y };
    }

    private static void printNumbers(int... arr) {
        System.out.println("The numbers are: ");
        System.out.println("A= " + arr[0] + " B= " + arr[1] + " C= " + arr[2]);
    }
}
