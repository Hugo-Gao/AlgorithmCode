package pointToOffer;

public class OneAddToN
{
    public static void main(String[] args)
    {

        System.out.println(sum_soulution(100));
    }


    static int sum_soulution(int n)
    {
        int ans = n;
        boolean t = ((ans != 0) && ((ans += sum_soulution(n - 1)) != 0));
        return ans;
    }

}
