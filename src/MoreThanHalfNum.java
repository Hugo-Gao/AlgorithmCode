public class MoreThanHalfNum
{

    public static void main(String[] args)
    {
        int[] nums = new int[]{1,2,3,2,2,2,5,4,21,1,1,1,1,1,1,11,1,};
        System.out.println(moreThanHalNum(nums));

    }

    static int moreThanHalNum(int[] nums)
    {
        if (nums.length == 0)
        {
            return 0;
        }
        int middle = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != middle)
        {
            if (index > middle)
            {
                end = index - 1;
                index = partition(nums, start, end);
            } else
            {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        return nums[middle];
    }

    private static int partition(int[] nums, int start, int end)
    {
        int pivot = nums[start];
        while (start < end)
        {
            while (start < end && nums[end] >= pivot)
            {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] < pivot)
            {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    public static void print(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + ",");
        }
    }
}
