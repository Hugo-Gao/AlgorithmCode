package pointToOffer;

/**
 * 在排序数组中查找数字
 */

public class SearchNumInSortArray
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumTimes(array, 0));
    }

    /**
     * 找出数字在排序数组中出现的次数
     * @param array
     * @param target
     * @return
     */
    static int getNumTimes(int[] array,int target)
    {
        int firstIndex = findFirstK(array, 0, array.length-1, target);
        int endIndex = lastIndexK(array, 0, array.length - 1, target);
        if(firstIndex==-1&&endIndex==-1) return 0;
        return endIndex - firstIndex + 1;
    }

    private static int lastIndexK(int[] array, int start, int end, int target)
    {
        if(start>end) return -1;
        while (start <= end)
        {
            int mid = (start + end) >> 1;
            if(array[mid]<target)
            {
                start = mid + 1;
            }else if(array[mid]>target)
            {
                end = mid - 1;
            }
            else
            {
                if(mid==array.length-1||array[mid+1]!=target)
                {
                    return mid;
                }else
                {
                    return lastIndexK(array, mid+1, end, target);
                }
            }
        }
        return -1;
    }

    private static int findFirstK(int[] array, int start, int end, int target)
    {
        if(start>end) return -1;
        while (start <= end)
        {
            int mid = (start + end) >> 1;
            if(array[mid]<target)
            {
                start = mid + 1;
            }else if(array[mid]>target)
            {
                end = mid - 1;
            }
            else
            {
                if(mid==0||array[mid-1]!=target)
                {
                    return mid;
                }else
                {
                    return findFirstK(array, start, mid - 1, target);
                }
            }
        }
        return -1;
    }

    static int binarySearch(int[] array, int start, int end,int target)
    {
        if(end<start) return -1;
        while (start <= end)
        {
            int mid=start+((end-start)>>1);
            if (array[mid] < target)
            {
                start = mid + 1;
            }else if(array[mid]>target)
            {
                end = mid - 1;
            }else
            {
                return mid;
            }
        }
        return -1;
    }
}
