public class UglyNumber
{
    public static void main(String[] args)
    {
        System.out.println(findNthUglyNumber(1500));
    }

    public static int findNthUglyNumber(int index)
    {
        if (index < 0)
        {
            return 0;
        }
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int nextUglyIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyIndex < index)
        {
            int min = min(uglyNums[p2] * 2, uglyNums[p3] * 3, uglyNums[p5] * 5);
            uglyNums[nextUglyIndex] = min;
            while (uglyNums[p2]*2<=uglyNums[nextUglyIndex])
                p2++;
            while (uglyNums[p3]*3<=uglyNums[nextUglyIndex])
                p3++;
            while (uglyNums[p5]*5<=uglyNums[nextUglyIndex])
                p5++;
            nextUglyIndex++;
        }
        return uglyNums[index - 1];

    }

    public static int min(int a, int b, int c)
    {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
}
