package Tree.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfsWithRecursion(root, ans);
        return ans;
    }

    // Dfs with recursion
    public static void dfsWithRecursion(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        dfsWithRecursion(root.left, ans);
        dfsWithRecursion(root.right, ans);
        ans.add(root.val);
    }

    // No-Recursion with stack
    public static void dfsWithStack(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(0, cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
    }

    // Divide and conquer + recursion
    public static List<Integer> postorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return ans;
        }

        List<Integer> left = postorderTraversal(root.left, ans);
        List<Integer> right = postorderTraversal(root.right, ans);
        ans.addAll(left);
        ans.addAll(right);
        ans.add(root.val);
        return ans;
    }
}
