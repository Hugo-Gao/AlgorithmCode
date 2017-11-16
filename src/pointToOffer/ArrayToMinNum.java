package pointToOffer;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayToMinNum
{
    public static void main(String[] args)
    {
    arrayToMinNum(new Integer[]{3, 32, 321});
    }

    private static void arrayToMinNum(Integer[] arrays)
    {
        Arrays.sort(arrays, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            {
                return (a+""+b).compareTo(b+""+a);
            }
        });
        for (Integer integer : arrays)
        {
            System.out.print(integer);
        }
    }
}
