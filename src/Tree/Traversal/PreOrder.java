package Tree.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    public static List<Integer> preorder(TreeNode root) {
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

        ans.add(root.val);
        dfsWithRecursion(root.left, ans);
        dfsWithRecursion(root.right, ans);
    }

    // No-Recursion with stack
    // time: O(n)
    // space: O(n)
    public static void dfsWithStack(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // Divide and conquer with recursion
    // time: O(n)
    // space: O(n)
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        ans.add(root.val);
        ans.addAll(left);
        ans.addAll(right);

        return ans;
    }

    public static void main(String[] args) {

    }
}



