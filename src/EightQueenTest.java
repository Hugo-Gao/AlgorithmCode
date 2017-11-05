public class EightQueenTest
{
    public static void main(String[] args)
    {
        System.out.println("共有" + eightQueenQuestion() + "种走法");
    }

    public static int count=0;

    //下标表示行号，内容表示列号
    public static int eightQueenQuestion()
    {

        int[] columnIndex = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        Permutation(columnIndex, 0);
        return count;
    }

    private static void Permutation(int[] columnIndex, int begin)
    {
        if(begin==columnIndex.length)
        {
            if(judgeIfTrue(columnIndex))
            {
                print(columnIndex);
                System.out.println();
                count++;
            }
        }
        for (int i = begin; i < columnIndex.length; i++)
        {
            swap(columnIndex, i, begin);
            Permutation(columnIndex, begin + 1);
            swap(columnIndex, i, begin);
        }
    }

    public static void print(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i]+",");
        }
    }

    public static void swap(int[] columnIndex, int i, int j)
    {
        int temp = columnIndex[i];
        columnIndex[i] = columnIndex[j];
        columnIndex[j] = temp;
    }

    public static boolean judgeIfTrue(int[] columnIndex)
    {
        for (int i = 0; i < columnIndex.length; i++)
        {
            for (int j = i+1; j < columnIndex.length; j++)
            {
                if (i - j == columnIndex[i] - columnIndex[j] || j - i == columnIndex[i] - columnIndex[j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
