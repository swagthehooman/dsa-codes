import java.util.*;

public class activity_selection {
    public static void main(String[] args) {
        int S[] = { 1, 3, 0, 5, 8, 5 };
        int F[] = { 2, 4, 6, 7, 9, 9 };
        sort(S, F);
        activity(S.length, S, F);
    }

    public static void activity(int n, int S[], int F[]) {
        List<Integer> soln = new ArrayList<>();
        soln.add(1);
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (S[i] >= F[j]) {
                soln.add(i + 1);
                j = i;
            }
        }
        display(soln);
    }

    public static void display(List<Integer> soln) {
        for (int x : soln)
            System.out.print(x + "\t");
    }

    public static void sort(int s[], int f[]) {
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length - i - 1; j++) {
                if (f[j] > f[j + 1]) {
                    int temp = f[j];
                    f[j] = f[j + 1];
                    f[j + 1] = temp;

                    temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
    }

}
