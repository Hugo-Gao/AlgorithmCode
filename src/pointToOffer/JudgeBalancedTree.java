package pointToOffer;

/**
 * 判断是否是平衡二叉树
 */
public class JudgeBalancedTree
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        System.out.println(isBalancedTree(root));

    }


    public static boolean isBalancedTree(TreeNode root)
    {
        if(root==null) return true;
        if(isBalanced(root)!=-1)
        {
            return true;
        }else
        {
            return false;
        }
    }

    public static int isBalanced(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int left = isBalanced(root.left);
        int right = isBalanced(root.right);
        int depth=-1;
        if (left != -1 && right != -1)
        {
            int diff = Math.abs(left - right);
            if (diff <= 1)
            {
                depth = Math.max(left, right) + 1;
            }
        }
        return depth;
    }

}
