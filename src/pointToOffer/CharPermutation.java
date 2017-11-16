package pointToOffer;

public class CharPermutation
{
    public static void main(String[] args)
    {
        Permutation(new char[]{'0','1','2','3','4','5','6','7'});
    }

    static void  Permutation(char[] s)
    {
        Permutation(s, 0);
    }

    private static void Permutation(char[] s, int begin)
    {
        if (begin == s.length)
        {
            System.out.println(s);
            return;
        }
        for(int i=begin;i<s.length;i++)
        {
            char temp = s[begin];
            s[begin] = s[i];
            s[i] = temp;
            Permutation(s, begin + 1);
            temp = s[begin];
            s[begin] = s[i];
            s[i] = temp;
        }
    }

    static void combination(char[] s)
    {
        for(int l=1;l<=s.length;l++)
        {
            combination(s, l,new StringBuilder(),0);
        }
    }

    private static void combination(char[] s, int l, StringBuilder sb,int index)
    {
        if (sb.length() == l)
        {
            System.out.println(sb);
            return;
        }
        for(int i=index;i<s.length;i++)
        {
            sb.append(s[i]);
            combination(s, l, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }



}
