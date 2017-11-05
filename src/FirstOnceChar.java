import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstOnceChar
{
    public static void main(String[] args)
    {
        System.out.println(findFirstOnceChar("abcdbawers"));
    }

    private static char findFirstOnceChar(String s)
    {
        if(s.length()==0) return ' ';
        List<Character> singleList = new ArrayList<>();
        Set<Character> duplicates = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (!duplicates.contains(s.charAt(i)))
            {
                if (singleList.indexOf(s.charAt(i)) == -1)
                {
                    singleList.add(s.charAt(i));
                } else
                {
                    singleList.remove((Character) s.charAt(i));
                    duplicates.add(s.charAt(i));
                }
            }
        }
        return singleList.get(0);
    }


}
