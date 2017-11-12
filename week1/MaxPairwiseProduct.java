import java.util.*;
import java.io.*;

public class MaxPairwiseProduct
{
    public static void main(String args[])
    {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
        {
            numbers.add(scanner.nextInt());
        }
        long max1 = getMaxPairProduct(numbers);
        System.out.println(max1);
    }

    static long getMaxPairProduct(List<Integer> numbers)
    {
        long result = 0;
        int n = numbers.size();

        int maxIndex1 = -1;
        for(int i = 0; i < n; ++i)
        {
            if(maxIndex1 == -1 || numbers.get(i) > numbers.get(maxIndex1))
            {
                maxIndex1 = i;
            }
        }
        int maxIndex2 = -1;
        for(int j = 0; j < n; ++j)
        {
            if(j != maxIndex1 && (maxIndex2 == -1 || numbers.get(j) > numbers.get(maxIndex2)))
            {
                maxIndex2 = j;
            }
        }
        return (long)numbers.get(maxIndex1) * numbers.get(maxIndex2);
    }

    static class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream)
        {
            try
            {
                br = new BufferedReader(new InputStreamReader(stream));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        String next()
        {
            while(st == null || !st.hasMoreTokens())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }
    }
}
