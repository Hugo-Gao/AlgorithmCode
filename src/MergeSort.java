import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args)
    {
        int[] num = new int[]{8,7,6,5,4,3,2,1};
        mergeSort(num, 0, num.length - 1);
        for (int i : num)
        {
            System.out.print(i+",");
        }
    }

    private static void mergeSort(int[] num, int start, int end)
    {
        if (start == end)
        {
            return;
        }

        int mid = (start + end) >> 1;
        mergeSort(num, start, mid);
        mergeSort(num, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = mid, j = end, z = temp.length - 1;
        while (i >= start && j >= mid + 1)
        {
            if (num[i] > num[j])
            {
                temp[z] = num[i];
                i--;
                z--;
            }else{
                temp[z] = num[j];
                j--;
                z--;
            }
        }
        while (i >= start)
        {
            temp[z] = num[i];
            z--;
            i--;
        }
        while (j >= mid + 1)
        {
            temp[z] = num[j];
            z--;
            j--;
        }
        for(i=0,j=start;i<temp.length;i++,j++)
        {
            num[j] = temp[i];
        }
    }
}
