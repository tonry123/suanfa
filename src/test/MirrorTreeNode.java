package test;

import niuke.IsSymmetrical;

/**
 * @description 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author: liguangwei
 * @create: 2021-04-12 11:43
 **/
public class MirrorTreeNode {

    public class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    //第二次编写
    public boolean mirror(TreeNode treeNode){
        TreeNode p2 = getMirror(treeNode);
        return isMirror(treeNode, p2);
    }

    public boolean isMirror(TreeNode treeNode1, TreeNode treeNode2){
        if(treeNode1 == null && treeNode2 == null){
            return true;
        }
        if(treeNode1 == null || treeNode2 == null){
            return false;
        }
        return treeNode1.val == treeNode2.val && isMirror(treeNode1.left, treeNode2.left) & isMirror(treeNode1.right, treeNode2.right);
    }

    public TreeNode getMirror(TreeNode treeNode){
        TreeNode top = null;
        if(treeNode == null) {
             return null;
        }
        top = new TreeNode(treeNode.val);
        top.left = getMirror(treeNode.right);
        top.right = getMirror(treeNode.left);

        return top;
    }
}
