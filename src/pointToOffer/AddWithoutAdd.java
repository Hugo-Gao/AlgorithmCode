package pointToOffer;

public class AddWithoutAdd
{
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println(add(11,9));
    }

    static int add(int num1, int num2)
    {
        int sum, carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            System.out.println("sum = " + sum);
            System.out.println("carry = " + carry);
            num1=sum;
            num2 = carry;
        } while (carry != 0);
        return num1;
    }
}
