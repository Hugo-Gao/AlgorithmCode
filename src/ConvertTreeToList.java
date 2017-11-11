
import java.util.List;

public class ConvertTreeToList
{

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        printTreeNode(convertTreeToListNode(root));
    }


    public static TreeNode convertTreeToListNode(TreeNode root)
    {
        convertNode(root,null);
        while (root.left != null)
        {
            root = root.left;
        }
        return root;
    }
    private static TreeNode convertNode(TreeNode root,TreeNode lastNode)
    {
        if(root.left!=null)
        {
            lastNode= convertNode(root.left, lastNode);
        }

        //连接
        root.left = lastNode;
        if (lastNode != null)
        {
            lastNode.right = root;
        }
        //
        lastNode = root;
        if (root.right != null)
        {
            lastNode=convertNode(root.right, lastNode);
        }
        return lastNode;
    }

    public static void printTreeNode(TreeNode root)
    {
        while (root != null)
        {
            System.out.print(root.val+",");
            root = root.right;
        }
    }

    static class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int val)
        {
            this.val = val;
        }
    }


    static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val)
        {
            this.val = val;
        }
    }
}
