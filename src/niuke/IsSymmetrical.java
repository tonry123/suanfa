package niuke;


import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description  二叉树是对称
 * @author: liguangwei
 * @create: 2020-08-08 21:23
 **/
public class IsSymmetrical {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left=new TreeNode(6);
        treeNode.right=new TreeNode(6);
        treeNode.left.left=new TreeNode(5);
        treeNode.left.right=new TreeNode(7);
        treeNode.right.left=new TreeNode(8);
        treeNode.right.right=new TreeNode(5);
        System.out.println(isSymmetrical(treeNode));
    }

    public static class TreeNode{
        int val=0;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

//    public static boolean isSymmetrical(TreeNode pRoot) {
//        TreeNode node = getMirror(pRoot);
//        return isSymmetrical(pRoot,node);
//    }
//
//    public static boolean isSymmetrical(TreeNode pRoot,TreeNode node){
//        if(pRoot==null && node == null)
//            return true;
//        else if(pRoot==null || node == null)
//            return false;
//        if(pRoot.val == node.val)
//            return isSymmetrical(pRoot.left,node.left) && isSymmetrical(pRoot.right,node.right);
//        return false;
//    }
//
//    public static TreeNode getMirror(TreeNode pRoot){
//        if(pRoot == null)
//            return null;
//        TreeNode treeNode = new TreeNode(pRoot.val);
//        treeNode.left=getMirror(pRoot.right);
//        treeNode.right=getMirror(pRoot.left);
//        return treeNode;
//
//    }

    public static boolean isSymmetrical(TreeNode  pRoot){
        TreeNode p2 = getMirror(pRoot);
        return isSymmetrical(pRoot,p2);

    }

    public static boolean isSymmetrical(TreeNode pRoot, TreeNode node){
        if(pRoot == null && node == null){
            return true;
        }
        if (pRoot == null || node == null) {

            return false;
        }
        if (pRoot.val == node.val){
            return isSymmetrical(pRoot.right,node.right) && isSymmetrical(pRoot.left, node.left);
        }
        return false;

    }



    public static TreeNode getMirror(TreeNode pRoot){
        if(pRoot == null){
            return null;
        }
        TreeNode t = new TreeNode(pRoot.val);

        t.left = getMirror(pRoot.right);
        t.right = getMirror(pRoot.left);
        return t;
    }




    //第二次编写
    public boolean mirror2(TreeNode treeNode){
        TreeNode  p2 = getMirror2(treeNode);
        return isMirror2(treeNode, p2);
    }


    public boolean isMirror2(TreeNode treeNode1, TreeNode treeNode2){
        if(treeNode1 == null && treeNode2 == null){
            return true;
        }

        if(treeNode1 == null || treeNode2 == null){
            return false;
        }
        if(treeNode1.val == treeNode2.val){
            return isMirror2(treeNode1.left, treeNode2.left) && isMirror2(treeNode1.right, treeNode2.right);
        }
        return false;
    }

    public TreeNode getMirror2(TreeNode treeNode){
        if(treeNode == null){
            return null;
        }

        TreeNode treeNode_x = new TreeNode(treeNode.val);

        treeNode_x.left = getMirror2(treeNode.right);
        treeNode_x.right = getMirror2(treeNode.left);
        return treeNode_x;
    }



}
