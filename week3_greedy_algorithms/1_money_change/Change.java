import java.util.Scanner;

public class Change {
    /*private static int getChange(int m) {

         return m/10+((m%10)/5)+((m%10)%5);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }*/
    private static int getChange(int m, int[] d) {

        return m/d[2]+((m%d[2])/d[1])+((m%d[2])%d[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 100; i++) {

            //int m = scanner.nextInt();
            System.out.println(i+" - "+getChange(i, new int[]{1, 8, 20}));
        }
    }
}

