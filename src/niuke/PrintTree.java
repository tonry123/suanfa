package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author: liguangwei
 * @create: 2020-08-05 21:02
 **/
public class PrintTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(5);
        treeNode.right.left=new TreeNode(6);
        treeNode.right.right=new TreeNode(7);
        levelOrderTraversal(treeNode);
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        depth(pRoot,1,arrayLists);
        return arrayLists;

    }

    public static void depth(TreeNode pRoot, int i, ArrayList<ArrayList<Integer>> lists){
        if(pRoot == null) return;
        if(lists.size() < i)
            lists.add(new ArrayList<Integer>());
        lists.get(i-1).add(pRoot.val);
        depth(pRoot.left,i+1,lists);
        depth(pRoot.left,i+1,lists);
    }

    /**
     * 二叉树 层次遍历 通过队列
     */
    public static void levelOrderTraversal(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.val);

            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }

}
