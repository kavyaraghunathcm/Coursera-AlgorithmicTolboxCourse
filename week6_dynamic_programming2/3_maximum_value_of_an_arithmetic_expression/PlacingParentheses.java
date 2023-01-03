import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operetors = new ArrayList<>();

        String number = "";
        for (int i = 0; i < exp.length(); i++) {

            char c = exp.charAt(i);
            if ("+*-".contains(c + "")) {
                numbers.add(Integer.parseInt(number));
                operetors.add(c);
                number = "";
            } else {
                number += c;
            }
        }
        numbers.add(Integer.parseInt(number));

        int nlength = numbers.size();
        long[][] min = new long[nlength][nlength];
        long[][] max = new long[nlength][nlength];
        for (int i = 0; i < nlength; i++) {
            max[i][i] = numbers.get(i);
            min[i][i] = numbers.get(i);
        }
        for (int s = 1; s <nlength ; s++) {
            for (int i = 0; i <nlength-s ; i++) {
                int j=i+s;
                long[] minAndMax=minAndMAx(i,j,min,max,operetors);
                min[i][j]=minAndMax[0];
                max[i][j]=minAndMax[1];

            }
        }
        return max[0][nlength-1];
    }

    private static long[] minAndMAx(int i, int j, long[][] min, long[][] max, List<Character> operators) {
        long[] minAndMAx={Long.MAX_VALUE,Long.MIN_VALUE};
        for (int k = i; k <j ; k++) {
            long a=eval(max[i][k],max[k+1][j],operators.get(k));
            long b=eval(max[i][k],min[k+1][j],operators.get(k));
            long c=eval(min[i][k],max[k+1][j],operators.get(k));
            long d=eval(min[i][k],min[k+1][j],operators.get(k));
            minAndMAx[0]=minimum(new long[]{minAndMAx[0], a, b, c, d});
            minAndMAx[1]=maximum(new long[]{minAndMAx[1], a, b, c, d});
        }
        return minAndMAx;
    }

    private static long minimum(long[] n){
        long min=n[0];
        for (int i = 1; i < n.length; i++) {
            if(n[i]<min){
                min=n[i];
            }
        }
        return min;
    }
    private static long maximum(long[] n){
        long max=n[0];
        for (int i = 1; i < n.length; i++) {
            if(n[i]>max){
                max=n[i];
            }
        }
        return max;
    }


    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

