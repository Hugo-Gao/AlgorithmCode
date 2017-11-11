public class NumberOccurrenceOnce
{
    public static void main(String[] args)
    {
        twoNumberOccurrenceOnce(new int[]{2,3,3,2,5,5});
    }


    /**
     * 找出一个只出现一次的数字，其他都出现了两次
     * @param array
     * @return
     */
    static int oneNumberOccurrenceOnce(int[] array)
    {
        int num = array[0];
        for (int i = 1; i < array.length; i++)
        {
            num ^= array[i];
        }
        return num;
    }


    /**
     * 找出两个只出现一次的数字，其他都出现了两次
     * @param array
     */
    static void twoNumberOccurrenceOnce(int[] array)
    {
        int num=0;
        for (int i = 0; i < array.length; i++)
        {
            num ^= array[i];
        }
        int indexOfFirst1 = findFirstBitIs1(num);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (isBit1(array[i], indexOfFirst1))
            {
                num1 ^= array[i];
            }else
            {
                num2 ^= array[i];
            }
        }
        System.out.println("这两个数字是" + num1 + ", " + num2);

    }

    static int findFirstBitIs1(int num)
    {
        int indexBit = 0;
        while (((num&1)==0)&&(indexBit<8*32))
        {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    static boolean isBit1(int num, int indexBit)
    {
        num = num >> indexBit;
        return (num & 1)==1;
    }

    static int FindNumberAppearingOnce(int numbers[], int length) throws Exception
    {
        if (numbers == null || length <= 0)
        {
            throw new Exception("输入错误");
        }

        int[] bitSum=new int[32];
        for(int i = 0; i <length; ++i)
        {
            int bitMask = 1;
            for(int j = 31; j >= 0; --j)
            {
                int bit = numbers[i] & bitMask;
                if(bit != 0)
                    bitSum[j] += 1;

                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for(int i = 0; i < 32; ++i)
        {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }
}
