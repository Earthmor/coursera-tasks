import java.util.*;

public class Fibonacci {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    List<Long> a = new ArrayList<Long>();
    a.add(0L);
    a.add(1L);
    for(int i = 2; i <= n; ++i){
      a.add(a.get(i-1) + a.get(i-2));
    }
    System.out.println(a.get(n));
  }
}
