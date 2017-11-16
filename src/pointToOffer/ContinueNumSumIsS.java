package pointToOffer;

public class ContinueNumSumIsS
{
    public static void main(String[] args)
    {
        getSequences(15);
    }

    static void getSequences(int target)
    {
        int start = 1;
        while (start <= target / 2)
        {
            StringBuilder sb = new StringBuilder();
            int begin = start;
            int sum = begin;
            sb.append(begin);
            while (sum<target)
            {
                begin++;
                sum += begin;
                sb.append("+").append(begin);
            }
            if (sum == target)
            {
                System.out.println(sb);
            }
            start++;
        }
    }
}
