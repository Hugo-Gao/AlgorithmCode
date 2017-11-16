package pointToOffer;

/**
 * n个骰子的点数出现的概率
 */
public class DiceProbability
{
    public static void main(String[] args)
    {
    }

    static void getProbability(int n)
    {
        if (n < 1)
        {
            return;
        }
        int maxNum = 6 * n;
        int minNum = n;
        int[] probablyArray = new int[maxNum - minNum + 1];
        probability(n, probablyArray);
        double total = Math.pow(6, n);
        double sum = 0;
        for (int i = n; i <= maxNum; i++)
        {
            double rate = probablyArray[i - n] / total;
            System.out.println(i + "的概率为--->" + rate);
            sum += rate;
        }
        System.out.println("sum is " + sum);
    }

    private static void probability(int n, int[] probablyArray)
    {
        for (int i = 1; i <= 6; i++) //当前
        {
            probability(n, n, i, probablyArray);
        }
    }

    private static void probability(int original, int current, int sum, int[] probablyArray)
    {
        if (current == 1)
        {
            probablyArray[sum - original]++;
        } else
        {
            for (int i = 1; i <= 6; i++)
            {
                probability(original, current - 1, i + sum, probablyArray);
            }
        }
    }


    /**
     * 循环解决 动态规划，自底而上
     * @param number
     * @param max
     */
    public static void printProbability2(int number, int max)
    {
        if (number < 1 || max < 1)
        {
            return;
        }
        int[][] probabilities = new int[2][max * number + 1];
        // 数据初始化
        for (int i = 0; i < max * number + 1; i++)
        {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }
        // 标记当前要使用的是第0个数组还是第1个数组
        int flag = 0;
        // 抛出一个骰子时出现的各种情况
        for (int i = 1; i <= max; i++)
        {
            probabilities[flag][i] = 1;
        }
        // 抛出其它骰子
        for (int k = 2; k <= number; k++)
        {
            // 如果抛出了k个骰子，那么和为[0, k-1]的出现次数为0
            for (int i = 0; i < k; i++)
            {
                probabilities[1 - flag][i] = 0;
            }
            // 抛出k个骰子，所有和的可能 i位可能的和
            for (int i = k; i <= max * k; i++)
            {
                probabilities[1 - flag][i] = 0;
                // 每个骰子的出现的所有可能的点数
                for (int j = 1; j <= i && j <= max; j++)
                {
                    // 统计出和为i的点数出现的次数
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = 1;
        for (int i = 0; i < number; i++)
        {
            total *= max;
        }
        int maxSum = number * max;
        for (int i = number; i <= maxSum; i++)
        {
            double ratio = probabilities[flag][i] / total;
            System.out.printf("%-8.4f", ratio);
        }
        System.out.println();
    }
}
