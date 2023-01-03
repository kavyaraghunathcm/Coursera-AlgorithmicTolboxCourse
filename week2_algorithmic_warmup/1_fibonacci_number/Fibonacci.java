import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;
    else{
      long fibNMinusTwo=0;
      long fibNMinusOne=1;

      for (int i = 2; i <=n ; i++) {
        long temp=fibNMinusTwo;
        fibNMinusTwo=fibNMinusOne;
        fibNMinusOne=fibNMinusOne+temp;

      }
      return fibNMinusOne;
    }

  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));

   /* for (int i = 0; i < 100; i++) {
      System.out.println(calc_fib(i));
    }*/
  }
}
