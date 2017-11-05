import java.util.ArrayList;
import java.util.TreeSet;

public class FindMinX
{
    public static void main(String[] args)
    {

        findMinX(new int[]{1,4,2,6,7,3,2},4);
    }

    public static void findMinX(int[] nums,int k)
    {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums)
        {
            if(set.size()==k&&num<set.last())
            {
                set.remove(set.last());
                set.add(num);
            }else if(set.size()<k)
            {
                set.add(num);
            }
        }
        System.out.println("The min k is "+set);
    }
}
