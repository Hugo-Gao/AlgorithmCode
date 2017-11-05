import java.util.ArrayList;
import java.util.List;

public class TranslateNumIntoAlphaBet
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(translate(32));
    }


    private static List<String> translate(int num) throws Exception
    {
        if(num<0) return null;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        translateCore(String.valueOf(num).toCharArray(), sb, res,0);
        return res;
    }

    private static void translateCore(char[] num, StringBuilder sb, List<String> res, int begin) throws Exception
    {
        if(begin==num.length)
        {
            res.add(sb.toString());
            return;
        }
            StringBuilder temp = new StringBuilder(sb);
            sb.append(numToChar(num[begin]-'0'));
            translateCore(num, new StringBuilder(sb), res, begin + 1);
            if(begin<num.length-1)
            {
                sb = new StringBuilder(temp);
                int two = Integer.parseInt(num[begin] + "" + num[begin + 1]) ;
                if (two >= 0 && two <= 25)
                {
                    sb.append(numToChar(two));
                    translateCore(num, new StringBuilder(sb), res, begin + 2);
                }
            }
    }

    public static char numToChar(int num) throws Exception
    {
        if (num < 0 || num > 25)
        {
            throw new Exception("Error Num");
        }
        return (char) ('a' + num);

    }
}
