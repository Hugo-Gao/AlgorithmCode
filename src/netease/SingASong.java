package netease;


import java.util.List;
import java.util.Scanner;

/**
 * Created by gaoyunfan on 2017/11/24
 * 小 Q 和牛博士合唱一首歌曲, 这首歌曲由 n 个音调组成, 每个音调由一个正整数表示。
 * 对于每个音调要么由小 Q 演唱要么由牛博士演唱, 对于一系列音调演唱的难度等于所有相邻音调变化幅度之和,
 * 例如一个音调序列是 8, 8, 13, 12, 那么它的难度等于 | 8 - 8| + |13 - 8| + |12 - 13| = 6(其中 || 表示绝对值)。
 * 现在要对把这 n 个音调分配给小 Q 或牛博士, 让他们演唱的难度之和最小, 请你算算最小的难度和是多少。
 * 如样例所示: 小 Q 选择演唱 {5, 6} 难度为 1, 牛博士选择演唱 {1, 2, 1} 难度为 2, 难度之和为 3, 这一个是最小难度和的方案了。
 * 输入描述:
 * 输入包括两行,第一行一个正整数n(1 ≤ n ≤ 2000) 第二行n个整数v[i](1 ≤ v[i] ≤ 10^6), 表示每个音调。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数,表示小Q和牛博士演唱最小的难度和是多少。
 * <p>
 * 输入例子 1:
 * 5
 * 1 5 6 2 1
 * <p>
 * 输出例子 1:
 * 3
 **/
public class SingASong
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int len = in.nextInt();
            int[] tones = new int[len];
            for (int i = 0; i < len; i++)
            {
                tones[i] = in.nextInt();
            }
            if (len < 3)
            {
                System.out.println("0");
            } else
            {
                int[][] dp = new int[len][len];
                int[] acc = new int[len];
                dp[0][0] = 0 - Math.abs(tones[1] - tones[0]);

                for (int i = 1; i < len; ++i)
                {
                    acc[i] = acc[i - 1] + Math.abs(tones[i] - tones[i - 1]);//第i位音调累计难度和
                    dp[i][i - 1] = acc[i - 1];//第一个人唱第i个音调，之前所有第二个人全部唱完,此为边界情况

                    for (int j = 0; j < i - 1; ++j)
                    {
                        dp[i][j] = dp[i - 1][j] + (acc[i] - acc[i - 1]);
                        dp[i][i - 1] = Math.min(dp[i][i - 1], dp[i - 1][j] + Math.abs(tones[i] - tones[j]));
                    }
                }
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < len - 1; ++j)
                {
                    min = Math.min(min, dp[len - 1][j]);
                }
                System.out.println(min);
            }
        }
    }

}
/**
 * 23
 * 24 13 2 4 54 23 12 53 12 23 42 13 53 12 24 12 11 24 42 52 12 32 42
 */
