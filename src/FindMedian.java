import java.util.Arrays;

public class FindMedian
{
    private static MaxHeap maxHeap = new MaxHeap();
    private static MinHeap minHeap = new MinHeap();

    public static void main(String[] args)
    {
        int[] nums = new int[]{4, 6, 2, 6, 7, 3, 6, 8, 9, 2};
        for (int num : nums)
        {
            insert(num);
        }
        Arrays.sort(nums);
        System.out.println("排序后数组");
        for (int num : nums)
        {
            System.out.print(num + " ");
        }
        System.out.println("中位数是"+getMedian());
    }

    public static void insert(int num)
    {
        if (((maxHeap.size() + minHeap.size()) & 1) == 0)
        {
            if (maxHeap.size() > 0 && num < maxHeap.getTop())
            {
                maxHeap.insert(num);
                num = maxHeap.getTop();
                maxHeap.remove();
            }
            minHeap.insert(num);
        }else
        {
            if (minHeap.size() > 0 && minHeap.getTop() < num)
            {
                minHeap.insert(num);
                num = minHeap.getTop();
                minHeap.remove();
            }
            maxHeap.insert(num);
        }
    }

    public static int getMedian()
    {
        int size = minHeap.size() + maxHeap.size();
        if (size == 0)
        {
            return Integer.MIN_VALUE;
        }

        int median = 0;
        if ((size & 1) == 1)
        {
            median = minHeap.getTop();
        }else
        {
            median = ((minHeap.getTop() + maxHeap.getTop()) / 2);
        }
        return median;
    }
}
