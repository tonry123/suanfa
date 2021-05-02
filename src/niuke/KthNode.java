package niuke;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */


import java.util.LinkedList;

/**
 * @description
 * @author: liguangwei
 * @create: 2020-08-03 22:07
 **/
public class KthNode {
    private static final int nums = 4;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);
        print(treeNode);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


//
//    public static LinkedList<TreeNode> list = new LinkedList<TreeNode>();
//
//    public static TreeNode KthNode(TreeNode pRoot, int k) {
//        startBuildList(pRoot);
//        if (list.size() < k || k < 1) return null;
//        else {
//            return list.get(k - 1);
//        }
//    }
//
//    public static void startBuildList(TreeNode root) {
//        if (root == null) return;
//        if (root.left != null) {
//            startBuildList(root.left);
//        }
//        list.add(root);
//        if (root.right != null) {
//            startBuildList(root.right);
//        }
//
//
//    }

    public static int k = 5;
    public static int count = 0;
    public static  void print(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        print(treeNode.left);
        count ++;
        if(count == k){
            System.out.println(treeNode.val);
        }


        print(treeNode.right);

    }
}
