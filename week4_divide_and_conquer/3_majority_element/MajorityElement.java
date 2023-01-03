import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }

        //write your code here
        int mid= left+(right-left)/2;
        int leftMajority= getMajorityElement(a,left,mid);
        int rightMajority=getMajorityElement(a,mid,right);
        if(leftMajority==rightMajority)return rightMajority;
        int countl=count(a, left, right,leftMajority);
        int countr=count(a,left,right,rightMajority);
        if(countl>mid-left){
            return leftMajority;
        }
        if (countr>mid-left){
            return rightMajority;
        }
        return -1;
    }

    private static int count(int[] a, int left, int mid, int key) {
        if(key==-1)return 0;
        int count=0;
        for (int i = left; i < mid; i++) {
            if(a[i]== key){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

