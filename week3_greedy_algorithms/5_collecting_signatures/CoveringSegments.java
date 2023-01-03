import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(SortedSet<Segment> segments) {
        //write your code here
        List<Integer> points=new ArrayList<>();
        /*int point = segments.first().end;
        points.add(point);*/
        Segment currSegment=new Segment(segments.first().start,segments.first().end);
        boolean first=true;
        for (Segment s: segments) {
            if(first){
                first=false;
                continue;
            }
            if( currSegment.end<s.start){
                points.add(currSegment.start);
                currSegment = s;
            }
            else{
                currSegment.start = Math.max(s.start, currSegment.start);
                currSegment.end = Math.min(s.end, currSegment.end);
            }

        }
        points.add(currSegment.start);

        return points;
        /*Map<Integer,Integer> freqMap= new HashMap<>();
        for (Segment segment: segments) {
            for (int i = segment.start; i <=segment.end ; i++) {
               if(freqMap.containsKey(i)){
                   freqMap.put(i, freqMap.get(i)+1);

               }
               else
               {freqMap.put(i,1);}
            }
        }
        int maxFreq=-1;
        int optimalPoint=-1;
        for (int key: freqMap.keySet()) {
            int freq=freqMap.get(key);
            maxFreq=Math.max(maxFreq,freq);
            if(maxFreq==freq){
                optimalPoint=key;
            }
        }
        points.add(optimalPoint);

        Iterator<Segment> iterator= segments.iterator();
        while (iterator.hasNext()){
            Segment s= iterator.next();
            if(s.start<=optimalPoint&& optimalPoint<=s.end){
                iterator.remove();
            }
        }
        if (segments.isEmpty()){
            return points;
        }

        else{
            return optimalPoints(points, segments);
        }*/
        /*int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }*/
    }

    private static class Segment {
        int start, end;
        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SortedSet<Segment> segments = new TreeSet<>(Comparator.comparingInt((Segment s)->s.start).thenComparingInt(s->s.end)) ;
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments.add(new Segment(start, end));
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
