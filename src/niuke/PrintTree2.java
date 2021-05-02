package niuke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @author: liguangwei
 * @create: 2020-08-08 18:28
 **/

public class PrintTree2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(5);
        treeNode.right.left=new TreeNode(6);
        treeNode.right.right=new TreeNode(7);
        System.out.println(Print(treeNode).toString());
    }

    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val=val;
        }
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        depth(pRoot,1,arrayLists);
        for(int i = 0; i < arrayLists.size(); i++){
            if(i % 2 == 1){
                Collections.reverse(arrayLists.get(i));
            }
        }
        return arrayLists;
    }

    public static <lists> void depth(TreeNode pRoot, int i,ArrayList<ArrayList<Integer>> lists){
        if(pRoot == null) return;
        if(lists.size() < i)
            lists.add(new ArrayList<Integer>());
        lists.get(i-1).add(pRoot.val);
        depth(pRoot.left, i + 1, lists);
        depth(pRoot.right, i + 1, lists);
    }
}
