package netease;

import java.util.Scanner;

/**
 * 魔法王国一共有 n 个城市, 编号为 0~n-1 号, n 个城市之间的道路连接起来恰好构成一棵树。
 * 小易现在在 0 号城市, 每次行动小易会从当前所在的城市走到与其相邻的一个城市, 小易最多能行动 L 次。
 * 如果小易到达过某个城市就视为小易游历过这个城市了, 小易现在要制定好的旅游计划使他能游历最多的城市,
 * 请你帮他计算一下他最多能游历过多少个城市 (注意 0 号城市已经游历了, 游历过的城市不重复计算)。
 * 输入描述:
 * 输入包括两行,第一行包括两个正整数n(2 ≤ n ≤ 50)和L(1 ≤ L ≤ 100),表示城市个数和小易能行动的次数。
 * 第二行包括n-1个整数parent[i](0 ≤ parent[i] ≤ i), 对于每个合法的i(0 ≤ i ≤ n - 2),在(i+1)号城市和parent[i]间有一条道路连接。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数,表示小易最多能游历的城市数量。
 * <p>
 * 输入例子 1:
 * 5 2
 * 0 1 2 3
 * <p>
 * 输出例子 1:
 * 3
 *///0 3 1 3 0 5 2 7 5
public class WalkTheCity
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), L = scan.nextInt();
        int parent[] = new int[n];
        int depth[] = new int[n];
        int maxStep = 0;
        int walk = 0;
        for (int i = 1; i < n; i++)
        {
            parent[i] = scan.nextInt();
            if ((depth[parent[i]] != 0 || parent[i] == 0))
            {
                depth[i] = depth[parent[i]] + 1;
                walk++;
            }
            if (depth[i] > maxStep)
            {
                maxStep = depth[i];
            }
        }
        int result = n - 1 - walk;
        for (int i = 1; result != 0; i++)
        {
            if (i == 10)
            {
                i = 1;
            }
            if (depth[i] == 0 && depth[parent[i]] != 0)
            {
                depth[i] = depth[parent[i]] + 1;
                result--;
            }
            if (depth[i] > maxStep)
            {
                maxStep = depth[i];
            }
            System.out.println("i=" + i + " depth[i]" + depth[i]);
        }
        System.out.println(maxStep);
        int count;
        if (maxStep >= L) //如果最长部署比能走的步数长
        {
            count=L;
        }else {
            count = (L - maxStep) / 2 + maxStep ;
        }
        if(count >= n - 1)
            count = n - 1;
        System.out.println(count+1);
    }
}
