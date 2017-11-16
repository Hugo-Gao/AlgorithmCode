package pointToOffer;

import java.util.Arrays;

public class FindOneTimes
{
    public static void main(String[] args)
    {
        System.out.println(numberOf1Between1AndN(21345));
    }

    static int numberOf1Between1AndN(int n)
    {
        if (n <= 0)
        {
            return 0;
        }
        return numberOf1(String.valueOf(n).toCharArray());
    }

    static int numberOf1(char[] str)
    {
        if (str == null||str.length==0)
        {
            return 0;
        }
        int first = str[0] - '0';
        if (str.length == 1 && first == 0)
        {
            return 0;
        }
        if (str.length == 1 && first > 0)
        {
            return 1;
        }
        int numFirstDigit = 0;
        if (first > 1)
        {
            numFirstDigit = powerBase10(str.length - 1);
        } else if (first == 1)
        {
            numFirstDigit = Integer.parseInt(new StringBuilder(String.valueOf(str)).deleteCharAt(0).toString())+1;
        }

        int numOtherDigits = first * (str.length - 1) * powerBase10(str.length - 2);
        int numRecursive = numberOf1(Arrays.copyOfRange(str, 1, str.length));
        return numFirstDigit + numOtherDigits + numRecursive;
    }

    private static int powerBase10(int n)
    {
        int result = 1;
        for (int i = 0; i < n; i++)
        {
            result *= 10;
        }
        return result;
    }
}
