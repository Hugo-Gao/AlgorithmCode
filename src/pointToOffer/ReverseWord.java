package pointToOffer;

public class ReverseWord
{
    public static void main(String[] args)
    {
        reverseWord("Student.");
    }

    static void reverseWord(String s)
    {
        char[] str = s.toCharArray();
        reverse(str, 0, str.length - 1);
        int end = 0, start = 0;
        while (end < str.length-1)
        {
            if(str[end]!=' ')
            {
                end++;
                continue;
            }
            reverse(str, start, end-1);
            end++;
            start = end;
        }
        System.out.println(str);
    }

    public static void reverse(char[] str, int begin, int end)
    {
        while (begin<end)
        {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }
}
