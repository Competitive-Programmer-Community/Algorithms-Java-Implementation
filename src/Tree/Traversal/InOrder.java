package Tree.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfsWithRecursion(root, ans);
        dfsWithStack(root, ans);
        return ans;
    }

    // Dfs with recursion
    // time: O(n)
    // space: O(n)
    public static void dfsWithRecursion(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        dfsWithRecursion(root.left, ans);
        ans.add(root.val);
        dfsWithRecursion(root.right, ans);
    }

    // No-recursion
    // time: O(n)
    // space: O(n)
    public static void dfsWithStack(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);

            if (cur.right == null) {
                while(!stack.isEmpty() && stack.peek().right == cur) {
                    cur = stack.pop();
                }
            } else {
                cur = cur.right;
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
    }

    // Divide and Conquer + Recursion
    // time: O(n)
    // space: O(n)
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        ans.addAll(left);
        ans.add(root.val);
        ans.addAll(right);

        return ans;
    }

    // Morris Inorder Traversal
    // https://leetcode.com/problems/recover-binary-search-tree/solution/
    // time: O(n)
    // space: O(1)
    public static List<Integer> MorrisInorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        TreeNode cur = root, predecessor = null;
        while(cur != null) {
            if (cur.left != null) {
                predecessor = cur.left;
                while(predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;

                } else {
                    predecessor.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }

            } else {
                ans.add(cur.val);
                cur = cur.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
