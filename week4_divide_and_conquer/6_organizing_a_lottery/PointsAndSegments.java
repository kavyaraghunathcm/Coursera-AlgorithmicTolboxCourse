import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PointsAndSegments {
    static Random random=new Random();
    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        randomizedQuickSort3(starts,ends,0, starts.length);
        return cnt;
    }


    private static int[] partition3(int[] a,int[]b, int l, int r) {
        //write your code here
        int x=a[l];
        int m1=l;
        int m2=l+1;
        for (int i = l+1; i <=r ; i++) {
            if (a[i] == x) {
                int t1 = a[i];
                int t2= b[i];
                a[i] = a[m2];
                b[i] = b[m2];
                a[m2] = t1;
                b[m2] = t2;

                m2++;
            }
            else if(a[i]<x){
                int t1 = a[m1];
                int t2 = b[m1];

                a[m1] = a[i];
                b[m1] =b[i];
                a[i]= a[m2];
                b[i]= b[m2];

                a[m2]=t1;
                b[m2]=t2;
                m1++;
                m2++;
            }

        }
        int[] m = {m1, m2};
        return m;
    }
    private static void randomizedQuickSort3(int[] a, int[] b,int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a,b, l, r);
        randomizedQuickSort3(a,b, l, m[0] - 1);
        randomizedQuickSort3(b,a, m[0],m[1]-1);
        randomizedQuickSort3(a,b, m[1], r);
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
        randomizedQuickSort3(starts,ends,0,starts.length-1);
        System.out.println(Arrays.toString(starts));
        System.out.println(Arrays.toString(ends));

    }
}

