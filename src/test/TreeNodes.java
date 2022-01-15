package test;

import niuke.PrintTree2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description
 * @author: liguangwei
 * @create: 2021-01-26 21:46
 **/
public class TreeNodes {
    public static class TreeNode{
        int val ;
        TreeNode left = null;
        TreeNode right = null;
        public  TreeNode(int val){
            this.val = val;
        }

    }

    public static void main(String[] args) {

            TreeNodes.TreeNode treeNode = new TreeNodes.TreeNode(1);
            treeNode.left=new TreeNodes.TreeNode(2);
            treeNode.right=new TreeNodes.TreeNode(3);
            treeNode.left.left=new TreeNodes.TreeNode(4);
            treeNode.left.right=new TreeNodes.TreeNode(5);
            treeNode.right.left=new TreeNodes.TreeNode(6);
            treeNode.right.right=new TreeNodes.TreeNode(7);
            TreeNodes treeNodes = new TreeNodes();
            treeNodes.front(treeNode);

    }

    /**
     * 一行一行遍历 从上倒下，从左到右 (如果是第一行从左至右，第二行从右至左，第三行从左至右。。。。,就反转list为奇数的list)
     */
    public ArrayList<ArrayList<Integer>> depth(TreeNode treeNode){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        depth(treeNode,1,lists);
        return lists;
    }
    public void depth(TreeNode treeNode, int i, ArrayList<ArrayList<Integer>> lists){

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(i > lists.size()){
            lists.add(list);
        }

            lists.get(i-1).add(treeNode.val);

        if(treeNode.left != null)
            depth(treeNode.left,i+1,lists);
        if(treeNode.right != null)
            depth(treeNode.right,i+1,lists);
    }
    //层次遍历
    public void theLeverTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        //新建一个队列，LinkedList实现了Quene接口，可以直接当作队列来用
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        TreeNode current;  //当前节点
        queue.offer(root);//根节点入队列

        while (!queue.isEmpty()) {
            current = queue.poll();  //取出队列的头节点
            System.out.print(current.val + " ");//输出队列的头节点的值
            if (current.left != null) {
                queue.offer(current.left);  //如果当前节点的左节点不为空，则左节点入队列
            }
            if (current.right != null) {
                queue.offer(current.right); //如果当前节点的右节点不为空，则右节点入队列
            }
        }
    }

    /**
     * 中序遍历
     * @param treeNode
     */
    public void mid(TreeNode treeNode){

        if(treeNode.left != null){
            mid(treeNode.left);
        }
        System.out.println(treeNode.val);
        if(treeNode.right != null){
            mid(treeNode.right);
        }


    }

    /**
     * 前序遍历
     */

    public void front(TreeNode treeNode){
        System.out.println(treeNode.val);
        if(treeNode.left != null){
            front(treeNode.left);
        }

        if(treeNode.right != null){
            front(treeNode.right);
        }


    }

    /*
    后序遍历
     */
    public void back(TreeNode treeNode){

        if(treeNode.right != null){
            back(treeNode.right);
        }

        if(treeNode.left != null){
            back(treeNode.left);
        }
        System.out.println(treeNode.val);


    }
    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff=left-right;
        if(diff> 1||diff<-1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    static int treeDepth(TreeNode root) {
        if (root != null) {
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

}
