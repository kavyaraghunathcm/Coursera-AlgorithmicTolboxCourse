import java.util.*;

public class FibonacciLastDigit {

    private static void fib(int[] f)
    {
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= 59; i++)
            f[i] = (f[i - 1] + f[i - 2]) % 10;
    }

    private static int getFibonacciLastDigit(long n)
    {
        int[] f = new int[60];

        fib(f);

        int index = (int)(n % 60L);

        return f[index];
    }



    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);

        /*for (int i = 0; i <1000 ; i++) {
            System.out.println(getFibonacciLastDigit(i));
        }*/
    }
}

