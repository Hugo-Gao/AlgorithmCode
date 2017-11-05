import java.util.HashMap;
import java.util.Map;

public class MaxValueOfGift
{
    public static void main(String[] args)
    {
        System.out.println(getMaxValue(new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}}));
    }


    static int getMaxValue(int[][] matrix)
    {
        if(matrix.length==0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] values = new int[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                int up=0;
                int left=0;
                if(i>0)
                {
                    up = values[i - 1][j];
                }
                if(j>0)
                {
                    left = values[i][j - 1];
                }
                int value = matrix[i][j] + Math.max(up, left);
                values[i][j] = value;
            }
        }
        return values[rows - 1][cols - 1];
    }

    public static int minPathSum(int[][] grid)
    {
        // write your code here
        int distance;
        if (grid.length <= 1)
        {
            return grid[0][0];
        }
        Map<String, Integer> memr = new HashMap<>();
        distance = grid[0][0] + Math.min(walk(grid, memr, 1, 0), walk(grid, memr, 0, 1));
        return distance;
    }

    private static int walk(int[][] grid, Map<String, Integer> memr, int down, int right)
    {
        if (down == grid.length - 1 && right == grid[0].length - 1)//到底了
        {
            return grid[down][right];
        }
        if (down >= grid.length - 1)//如果越界
        {
            return grid[down][right] + walk(grid, memr, down, right + 1);
        }
        if (right >= grid[0].length - 1)
        {
            return grid[down][right] + walk(grid, memr, down + 1, right);
        }
        int dis;
        if (memr.containsKey(down + "+" + right))
        {
            dis = memr.get(down + "+" + right);
        } else
        {
            dis = grid[down][right] + Math.min(walk(grid, memr, down + 1, right), walk(grid, memr, down, right + 1));
            memr.put(down + "+" + right, dis);
        }
        return dis;
    }
}
