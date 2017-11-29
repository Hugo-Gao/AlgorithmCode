package netease;

import java.util.Scanner;

/**
 * Created by gaoyunfan on 2017/11/25
 * https://www.nowcoder.com/question/next?pid=6910869&qid=126948&tid=12471407
 * 这道题的关键就是要找到在一个十字线上最多的点，首先请确定三个点，再判断其余n-3个点是否位于这三个点构建的十字上
 **/
public class ShotMonster
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x[] = new int[n];
        int y[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            x[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            y[i] = scanner.nextInt();
        }
        scanner.close();
        int maxshot = 0;
        if (n <= 3)
        {
            System.out.println(n);
            return;
        }
        for (int i = 0; i < n; i++)//选取第一个点
        {
            for (int j = 0; j < n; j++)//选取第二个点
            {
                if (j == i)
                {
                    continue;
                }
                int x1 = x[i] - x[j];
                int y1 = y[i] - y[j];
                for (int k = 0; k < n; k++)//选取第三个点注意不要重复了
                {
                    if (k == i || k == j)
                    {
                        continue;
                    }
                    int count = 3;//因为如果有三个点的话，必定最大为三.
                    for (int l = 0; l < n; l++)
                    {
                        if (l == i || l == j || l == k)
                        {
                            continue;
                        }
                        //计算斜率
                        int x2 = x[l] - x[k];
                        int y2 = y[l] - y[k];
                        int x3 = x[l] - x[i];
                        int y3 = y[l] - y[i];
                        if (x1 * x2 + y1 * y2 == 0 || x3 * y1 == x1 * y3)// (x1/y1)*(x2/y2)==-1   l与k连成直线与i,j垂直||l在i,j在的直线上
                        {
                            count++;
                        }
                    }
                    if (count > maxshot)
                    {
                        maxshot = count;
                    }
                }
            }
        }
        System.out.println(maxshot);
    }
}
