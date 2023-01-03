import java.util.*;
import java.io.*;

public class CarFueling {
    private static int computeMinRefills(int location, int dist, int tank, LinkedList<Integer> stops) throws Exception {
        if(location+tank>=dist) {
            return 0;
        }
        if(stops.isEmpty() ||stops.peek()-location>tank){
            throw new Exception();
        }

        int lastStop=location;
        while(!(stops.isEmpty())&& (stops.peek()-location)<=tank){
            lastStop=stops.pop();
        }
        return 1+computeMinRefills(lastStop,dist,tank,stops);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        LinkedList<Integer> stops= new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stops.add(scanner.nextInt());
        }
        int result=-1;
        try {
            result=computeMinRefills(0,dist,tank,stops);
        } catch (Exception ignored) {
        } finally {
            System.out.println(result);
        }
    }
}
