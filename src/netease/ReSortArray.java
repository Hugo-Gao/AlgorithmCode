package netease;

import java.util.Scanner;

/**
 * Created by gaoyunfan on 2017/11/19
 * 小易有一个长度为 N 的正整数数列 A = {A[1], A[2], A[3]..., A[N]}。
 牛博士给小易出了一个难题:
 对数列 A 进行重新排列, 使数列 A 满足所有的 A[i] * A[i + 1](1 ≤ i ≤ N - 1) 都是 4 的倍数。
 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 输入描述:
 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)


 输出描述:
 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。

 输入例子 1:
 2
 3
 1 10 100
 4
 1 2 3 4

 输出例子 1:
 Yes
 No
 **/
public class ReSortArray
{
    public static void main(String[] args)
    {
        int numOfArray;
        Scanner scanner = new Scanner(System.in);
        numOfArray = scanner.nextInt();
        for (int i = 0; i < numOfArray; i++)
        {
            int n = scanner.nextInt();
            int over2NUm = 0, below2Num = 0,equal1Num=0;
            for (int j = 0; j < n; j++)
            {
                int currentNum = scanner.nextInt();
                if (currentNum % 4 == 0)
                {
                    over2NUm++;
                }else {
                    below2Num++;
                    if (currentNum % 2 == 0)
                    {
                        equal1Num++;
                    }
                }
            }
            below2Num = below2Num - equal1Num +1;
            if (over2NUm >= below2Num - 1)
            {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }

}
