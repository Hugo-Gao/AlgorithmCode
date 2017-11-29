package netease;

/**
 * Created by gaoyunfan on 2017/11/22
 **/

import java.util.*;

/**
 * 一个合法的括号匹配序列被定义为:
 * 1. 空串 "" 是合法的括号序列
 * 2. 如果 "X" 和 "Y" 是合法的序列, 那么 "XY" 也是一个合法的括号序列
 * 3. 如果 "X" 是一个合法的序列, 那么 "(X)" 也是一个合法的括号序列
 * 4. 每个合法的括号序列都可以由上面的规则生成
 * 例如 "","()","()()()","(()())","(((()))" 都是合法的。
 * 从一个字符串 S 中移除零个或者多个字符得到的序列称为 S 的子序列。
 * 例如 "abcde" 的子序列有 "abe","","abcde" 等。
 * 定义 LCS(S,T) 为字符串 S 和字符串 T 最长公共子序列的长度, 即一个最长的序列 W 既是 S 的子序列也是 T 的子序列的长度。
 * 小易给出一个合法的括号匹配序列 s, 小易希望你能找出具有以下特征的括号序列 t:
 * 1、t 跟 s 不同, 但是长度相同
 * 2、t 也是一个合法的括号匹配序列
 * 3、LCS(s, t) 是满足上述两个条件的 t 中最大的
 * 因为这样的 t 可能存在多个, 小易需要你计算出满足条件的 t 有多少个。
 * <p>
 * 如样例所示: s = "(())()", 跟字符串 s 长度相同的合法括号匹配序列有:
 * "()(())", "((()))", "()()()", "(()())", 其中 LCS( "(())()", "()(())" ) 为 4, 其他三个都为 5, 所以输出 3.
 * 输入描述:
 * 输入包括字符串s(4 ≤ |s| ≤ 50,|s|表示字符串长度),保证s是一个合法的括号匹配序列。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个正整数,满足条件的t的个数。
 * <p>
 * 输入例子 1:
 * (())()
 * <p>
 * 输出例子 1:
 * 3
 */
public class LongestCommonBrackets
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(getBracketsNum(s));
    }


    private static int getBracketsNum(String brackets)
    {
        int num = brackets.length() / 2;
        LinkedList<String> list = new LinkedList<>();
        list.add("()");
        for (int i = 1; i < num; i++)//递加括号
        {
            int n = list.size();
            for (int j = 0; j < n; j++) //对上一数量括号进行迭代
            {
                StringBuilder str = new StringBuilder(list.getFirst());
                for (int k = 0; k <= str.length(); k++)
                {
                    StringBuilder temp = new StringBuilder(str);
                    temp.insert(k, "()");
                    if (!list.contains(temp.toString()))//如果没有则添加
                    {
                        list.add(temp.toString());
                    }
                }
                list.removeFirst();
            }
        }
        list.remove(brackets);
        int max = Integer.MIN_VALUE;
        int count=0;
        for (String s : list)
        {
            int lcs = LCS(brackets, s);
            if(lcs>max)
            {
                max = lcs;
                count=1;
            } else if (lcs == max)
            {
                count++;
            }
        }
        return count;
    }

    public static int LCS(String s, String t)
    {
        int[][] result = new int[s.length()+1][t.length()+1];
        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = 1; j <= t.length(); j++)
            {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else
                {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }

        return result[s.length() ][t.length() ];
    }
}
