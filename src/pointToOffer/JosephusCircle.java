package pointToOffer;

import java.util.ArrayList;
import java.util.List;

public class JosephusCircle
{
    public static void main(String[] args)
    {
        List<Integer> circle = new ArrayList<>();
        for (int i = 0; i <= 4; i++)
        {
            circle.add(i);
        }
        System.out.println(josephusCircle(circle, 3)+"个位置不会被杀");
    }

    private static int josephusCircle(List<Integer> list, int step)
    {
        List<Integer> circle = new ArrayList<>(list);
        int index = 0;
        while (circle.size() != 1)
        {
            index =(index+step-1)%circle.size();
            System.out.println("删除"+circle.get(index));
            circle.remove(index);
        }

        return list.indexOf(circle.get(0));
    }
}
