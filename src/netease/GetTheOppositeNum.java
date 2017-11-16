package netease;

import java.util.Scanner;

/**
 * 为了得到一个数的 "相反数", 我们将这个数的数字顺序颠倒, 然后再加上原先的数得到 "相反数"。
 * 例如, 为了得到 1325 的 "相反数", 首先我们将该数的数字顺序颠倒, 我们得到 5231, 之后再加上原先的数,
 * 我们得到 5231+1325=6556. 如果颠倒之后的数字有前缀零, 前缀零将会被忽略。例如 n = 100, 颠倒之后是 1.
 */
public class GetTheOppositeNum
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        System.out.println(getTheOppoNum(num));
    }

    private static int getTheOppoNum(String num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++)
        {
            sb.append(num.charAt(num.length() - 1 - i));
        }
        int origin = Integer.parseInt(num);
        int reverse = Integer.parseInt(sb.toString());
        return origin + reverse;
    }
}
