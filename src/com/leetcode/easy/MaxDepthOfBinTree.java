package com.leetcode.easy;

/**
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * Solution:
 * Time Complexity O(n)
 * space Complexity O(n) in worst case, O(log(n)) in average case
 */
public class MaxDepthOfBinTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root != null) return depth(root);
        else return 0;
    }

    private int depth(TreeNode root) {
        int leftNodeDepth = 0, rightNodeDepth = 0;
        if (root.left != null) {
            leftNodeDepth = depth(root.left);
        }
        if (root.right != null) {
            rightNodeDepth = depth(root.right);
        }
        return Math.max(leftNodeDepth, rightNodeDepth) + 1;
    }
}
