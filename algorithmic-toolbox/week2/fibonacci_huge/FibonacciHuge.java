import java.util.*;

public class FibonacciHuge {

    private static long getFibonacciHugeNaive(long n, long m) {
      if(n <= 1){
        return n;
      }

      long periodSize = getPeriodSize(m);
      System.out.println("periodSize : " + periodSize);
      n = n % periodSize;
      System.out.println("n : " + n);

      long previous = 0;
      long current = 1;
      for(int i = 0; i < n - 1; ++i) {
        long tmp_previous = previous;
        previous = current;
        current = (tmp_previous + current) % m;
      }
      return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }

    private static long getPeriodSize(long m) {
      List<Long> period = new ArrayList<Long>();
      period.add(0L);
      period.add(1L);
      for(int i = 2; i < m * 6; ++i){
        period.add((period.get(i-1) + period.get(i-2))%m);
        if(period.get(i) == 1 && period.get(i - 1) == 0){
          break;
        }
      }
      return period.size();
    }
}
