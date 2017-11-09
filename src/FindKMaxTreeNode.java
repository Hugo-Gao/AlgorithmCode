public class FindKMaxTreeNode
{
    public static void main(String[] args)
    {
        TreeNode pRoot = new TreeNode(5);
        pRoot.left = new TreeNode(3);
        pRoot.left.left = new TreeNode(2);
        pRoot.left.right = new TreeNode(4);
        pRoot.right = new TreeNode(7);
        pRoot.right.left = new TreeNode(6);
        pRoot.right.right = new TreeNode(8);
        System.out.println(findKMaxTreeNode(pRoot,new int[]{4}));
    }

    private static TreeNode findKMaxTreeNode(TreeNode pRoot, int[] k)
    {
        TreeNode target = null;
        if (pRoot.left != null)
        {
            target=findKMaxTreeNode(pRoot.left, k);
        }
        if (target == null)
        {
            if(k[0]==1) target=pRoot;
            k[0]--;
        }
        if(target==null&&pRoot.right!=null)
        {
            target=findKMaxTreeNode(pRoot.right, k);
        }
        return target;
    }
}
