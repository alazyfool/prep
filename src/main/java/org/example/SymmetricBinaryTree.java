package com.company;

public class SymmetricBinaryTree {
    public static void main(String[] args) {

    }
}

//Definition for binary tree
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {
   val = x;
   left=null;
   right=null;
  }
}
class Solution8 {
    public int isSymmetric(TreeNode A) {
        return isSymmetricHelper(A.left, A.right) ? 1 : 0;
    }

    boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        }
        if (left.val == right.val) {
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        } else {
            return false;
        }
    }

}
