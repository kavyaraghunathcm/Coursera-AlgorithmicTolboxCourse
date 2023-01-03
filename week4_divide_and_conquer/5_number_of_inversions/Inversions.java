import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        int i = left, j = ave, k = left;
        while (i < ave && j < right) {
            if (a[i] > a[j]) {
                numberOfInversions += ave - i;
                b[k] = a[j];
                j++;
            } else {
                b[k] = a[i];
                i++;
            }
            k++;
        }
        while (i < ave) {
            b[k] = a[i];
            k++;
            i++;
        }
        while (j < right) {
            b[k] = a[j];
            k++;
            j++;
        }
        copy(b, a,left,right);
        return numberOfInversions;
    }

    private static void  copy(int[] a,int[] b,int  l,int r) {
        while (l < r) {
            b[l] = a[l];
            l += 1;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

