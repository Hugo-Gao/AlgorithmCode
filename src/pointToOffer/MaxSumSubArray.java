package pointToOffer;

public class MaxSumSubArray
{
    public static void main(String[] args)
    {
        //new int[]{-100,1,-100,-100}
        System.out.println(findSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
    }

    public static int findSubArray(int[] nums)
    {
        if (nums.length == 0)
        {
            return 0;
        }
        int curSum=0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            if (curSum <= 0)
            {
                curSum = nums[i];
            }else {
                curSum += nums[i];
            }
            if (curSum > greatestSum)
            {
                greatestSum = curSum;
            }
        }

        return greatestSum;
    }
}
