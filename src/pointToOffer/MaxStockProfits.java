package pointToOffer;

public class MaxStockProfits
{
    public static void main(String[] args)
    {
        System.out.println(maxStockProfits(new int[]{9,11,8,5,7,12,16,14}));
    }

    static int maxStockProfits(int[] prices)
    {
        int profits = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            if(prices[i]<minPrice)
            {
                minPrice = prices[i];
                continue;
            }
            if (prices[i] - minPrice > profits)
            {
                profits = prices[i] - minPrice;
            }
        }
        return profits;
    }
}
