package pointToOffer;

import java.util.Arrays;


/**
 * 最长不含重复字符的子字符串
 */
public class LongestSubStringWithoutDuplicate
{
    public static void main(String[] args)
    {
        System.out.println(findLongest("arabcacfr"));
    }

    public static int findLongest(String s)
    {
        if(s.length()==0) return 0;
        int maxLen = 0;
        int curLen=0;
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        for (int i = 0; i < s.length(); i++)
        {
            if (alphabet[s.charAt(i) - 'a'] == -1)
            {
                curLen++;
            }else
            {
                int dis=i - alphabet[s.charAt(i) - 'a'];
                if(dis>curLen)
                {
                    curLen++;
                }else
                {
                    if(curLen>maxLen)
                        maxLen=curLen;
                    curLen = dis;
                }
            }
            alphabet[s.charAt(i) - 'a'] = i;//更新为上一次出现的位置
        }
        return Math.max(curLen, maxLen);
    }
}
