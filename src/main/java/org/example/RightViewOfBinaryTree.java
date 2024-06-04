package com.company;

import java.util.ArrayList;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);



//        n4.left = n8;
//        n2.left = n4;
//        n2.right = n5;
//
//        n3.left = n6;
//        n3.right = n7;
//
        n4.right = n5;
        n2.right = n4;
        n1.left = n2;
        n1.right = n3;

        Solution70 obj = new Solution70();

        ArrayList<Integer> answer = obj.solve(n1);
        System.out.println(answer);

    }
}

class Solution70 {
    ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> answerArray = new ArrayList<>();
        solutionHelper(A, answerArray, 0);
        return answerArray;
    }

    void solutionHelper(TreeNode node, ArrayList<Integer> result, int currentDepth) {
        if (node == null) {
            return;
        }

        if (currentDepth == result.size()) {
            result.add(node.val);
        }

        solutionHelper(node.right, result, currentDepth + 1);
        solutionHelper(node.left, result, currentDepth + 1);
    }


}