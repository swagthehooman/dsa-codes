public class MatrixMultiplication {

    static char name;

    public static void main(String[] args) {
        int p[] = { 5, 10, 3, 12, 5, 50, 6 };
        int n = 7;
        int m[][] = MCM(n, p);
        System.out.println("Optimal solution for matrix multiplication\t" + m[1][n - 1]);
        System.out.println("the matrix chain:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] MCM(int n, int p[]) {
        int m[][] = new int[n][n];
        int s[][] = new int[n][n];
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = m[i][k] + m[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    if (temp < m[i][j]) {
                        m[i][j] = temp;
                        s[i][j] = k;
                    }
                }
            }
        }
        System.out.println("Sequence matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }
        name = 'A';
        System.out.println("The optimal way to solve");
        printSequence(1, n - 1, n, s);
        return m;
    }

    public static void printSequence(int i, int j, int n, int[][] S) {
        if (i == j) {
            System.out.print(name++);
            return;
        }
        System.out.print("(");
        printSequence(i, S[i][j], n, S);
        printSequence(S[i][j] + 1, j, n, S);
        System.out.print(")");
    }

}
