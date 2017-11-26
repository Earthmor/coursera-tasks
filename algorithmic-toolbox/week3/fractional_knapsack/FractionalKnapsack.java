import java.util.*;
import java.text.DecimalFormat;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int i = 0;
        sort(values, weights);
        //compute
        i = 0;
        while(capacity > 0 && weights.length > i) {
          int a = weights[i] < capacity ? weights[i] : capacity;
          value = value + (a * ((double)values[i] / weights[i]));
          capacity = capacity - a;
          i++;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        double r = getOptimalValue(capacity, values, weights);
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println(df.format(r));
    }

    public static void sort(int[] values, int[] weights) {
  		boolean swapped;
  		do {
  			swapped = false;
  			for(int i = 0; i < values.length - 1; i++){
          double f = (double) values[i] / weights[i];
          double s = (double) values[i + 1] / weights[i + 1];
          if(f < s){
  					swap(values, i, i+1);
            swap(weights, i, i+1);
  					swapped = true;
  				}
  			}
  		} while(swapped);
    }

    public static void swap(int[] array, int firstIndex, int secondIndex){
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }
}
