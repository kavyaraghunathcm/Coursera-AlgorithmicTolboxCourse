import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int alength = a.length;
        int blength = b.length;
        //write your code here
        int[][] d = new int[alength + 1][blength + 1];
        for (int i = 0; i <=alength; i++) {
            d[i][0] = 0;
        }
        for (int j = 0; j <= blength; j++) {
            d[0][j] = 0;
        }
        for (int j = 1; j <= blength; j++) {
            for (int i = 1; i <= alength; i++) {
                int insertion = d[i][j - 1];
                int deletion = d[i - 1][j];
                int match = d[i - 1][j - 1]+1;
                if (a[i - 1] == b[j - 1]) {
                    d[i][j] =match;
                } else {
                    d[i][j] = Math.max(insertion, deletion);
                }
            }
        }
       return d[alength][blength];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

