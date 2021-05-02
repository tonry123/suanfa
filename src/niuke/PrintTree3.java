package niuke;

/**
 * @description 中序遍历打印
 * @author: liguangwei
 * @create: 2020-08-09 09:50
 **/
public class PrintTree3 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(5);
        treeNode.right.left=new TreeNode(6);
        treeNode.right.right=new TreeNode(7);
        print(treeNode);
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static boolean flag = false;
    public static int sss = 6;
    public static void print(TreeNode pNode){
        if(pNode == null)
            return;
        print(pNode.left);
        if(pNode.val==sss){
            flag = true;
        }

        if(flag && pNode.val!=sss) {
            System.out.println(pNode.val);
            flag = false;

        }
        if(pNode == null)
            return;
        print(pNode.right);

    }
}
