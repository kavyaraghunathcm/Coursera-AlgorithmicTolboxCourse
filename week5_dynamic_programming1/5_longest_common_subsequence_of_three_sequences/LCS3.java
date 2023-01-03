import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int alength= a.length;
        int blength= b.length;
        int clength= c.length;

        int[][][] d= new int[alength+1][blength+1][clength+1];
        for (int k = 0; k <=clength ; k++) {
            for (int j = 0; j <= blength; j++) {
                for (int i = 0; i <= alength ; i++) {
                    if (i==0 || j==0 || k==0)d[i][j][k]=0;
                    else if(a[i-1]==b[j-1] && b[j-1]==c[k-1]){
                            d[i][j][k]=d[i-1][j-1][k-1]+1;
                    }
                    else{
                        d[i][j][k]=Math.max(d[i-1][j][k],Math.max(d[i][j-1][k],d[i][j][k-1]));
                    }
                }
            }
        }
        return d[alength][blength][clength];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

