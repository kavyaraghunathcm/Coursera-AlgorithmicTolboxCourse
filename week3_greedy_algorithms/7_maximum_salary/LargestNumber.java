import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        Arrays.sort(a,(s1,s2)->{
            int i1= Integer.parseInt(s1);
            int i2= Integer.parseInt(s2);
            if(i1==i2)return 0;
            if(Integer.parseInt(s1+s2)>Integer.parseInt(s2+s1)){
                return  -1;
            }
            else return 1;


        });

        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

