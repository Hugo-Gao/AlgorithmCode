package netease;



import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac" 是由下面碎片组成的:'aaa','bb','c'。
 * 牛牛现在给定一个字符串, 请你帮助计算这个字符串的所有碎片的平均长度是多少。
 */
public class StringFragment
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(getFragmentLength(str));
    }

    public static double getFragmentLength(String str)
    {
        if(str.length()==0||str.length()==1) return str.length();
        double length=0;
        int count=0;
        int start = 0;
        for (int i = 1; i < str.length(); i++)
        {
            if((str.charAt(start)!=str.charAt(i)))//如果当前字符与之前的字符不同
            {
                length += i - start;
                count++;
                start = i;
            }
            if (i == str.length() - 1)
            {
                length += i - start + 1;
                count++;
                break;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(length / count));
    }
}
