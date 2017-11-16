package netease;

import java.util.Scanner;

/**
 * 小易准备去魔法王国采购魔法神器, 购买魔法神器需要使用魔法币,
 * 但是小易现在一枚魔法币都没有, 但是小易有两台魔法机器可以通过投入 x(x 可以为 0) 个魔法币产生更多的魔法币。
 * 魔法机器 1: 如果投入 x 个魔法币, 魔法机器会将其变为 2x+1 个魔法币
 * 魔法机器 2: 如果投入 x 个魔法币, 魔法机器会将其变为 2x+2 个魔法币
 * 小易采购魔法神器总共需要 n 个魔法币, 所以小易只能通过两台魔法机器产生恰好 n 个魔法币,
 * 小易需要你帮他设计一个投入方案使他最后恰好拥有 n 个魔法币。
 */
public class MagicCoinMachine
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println(getThePath2(target));
    }


    private static String getThePath2(int target)
    {
        if(target<=0) return "";
        if(target<=2)
        {
            return target+"";
        }
        StringBuilder sb = new StringBuilder();
        while (target!=0)
        {
            if (target % 2 == 0)
            {
                sb.insert(0, "2");
                target = (target - 2) / 2;
            }else {
                sb.insert(0, "1");
                target = (target - 1) / 2;
            }
        }
        return sb.toString();
    }





    private static String getThePath(int target)
    {
        if(target<=0) return "";
        if(target<=2)
        {
            return target+"";
        }
        String[] paths = new String[target + 1];
        paths[1] = "1";
        paths[2] = "2";
        int temp = 0, i = 1;
        while (temp != target)
        {
            temp = machine1(i);//新的下标号
            if ((i * 2 + 1) < paths.length)
            {
                paths[i * 2 + 1] = paths[i] + "1";
            }
            if (temp == target)
            {
                break;
            }
            temp = machine2(i);
            if ((i * 2 + 2) < paths.length)
            {
                paths[i * 2 + 2] = paths[i] + "2";
            }
            i++;
        } return paths[paths.length - 1];
    }

    public static int machine1(int origin)
    {
        return 2 * origin + 1;
    }

    public static int machine2(int origin)
    {
        return 2 * origin + 2;
    }
}
