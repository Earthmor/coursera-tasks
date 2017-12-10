import java.util.*;

public class PrimitiveCalculator {

    private static List<Integer> optimal_sequence(int n) {
      List<Integer> sequence = new ArrayList<Integer>();
      while (n >= 1) {
          sequence.add(n);
          int[] answ = findMinCount(n);
          // answ[0] = findMinCount(n-1);
          // answ[1] = n - 1;
          // if(n % 3 == 0){
          //   int cnt = findMinCount(n/3);
          //   if(answ[0] > cnt){
          //     answ[0] = cnt;
          //     answ[1] = n/3;
          //   }
          // }
          // if(n % 2 == 0){
          //   int cnt = findMinCount(n/2);
          //   if(answ[0] > cnt){
          //     answ[0] = cnt;
          //     answ[1] = n/2;
          //   }
          // }
          n = answ[1];
      }
      Collections.reverse(sequence);
      return sequence;
    }

    private static int[] findMinCount(int n){
      if(n <= 0){
        return new int[]{0, 0};
      }
      int[] answ = new int[2];
      answ[0] = findMinCount(n-1)[0] + 1;
      answ[1] = n - 1;
      if(n % 3 == 0){
        int cnt = findMinCount(n/3)[0] + 1;
        if(answ[0] > cnt){
          answ[0] = cnt;
          answ[1] = n/3;
        }
      }
      if(n % 2 == 0){
        int cnt = findMinCount(n/2)[0] + 1;
        if(answ[0] > cnt){
          answ[0] = cnt;
          answ[1] = n/2;
        }
      }
      return answ;



      // int minCount = findMinCount(n-1) + 1;
      // if(n % 3 == 0){
      //   int cnt = findMinCount(n/3) + 1;
      //   if(minCount > cnt){
      //     minCount = cnt;
      //   }
      // }
      // if(n % 2 == 0){
      //   int cnt = findMinCount(n/2) + 1;
      //   if(minCount > cnt){
      //     minCount = cnt;
      //   }
      // }
      // return minCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
