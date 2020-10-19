package Tree.SegmentTree;


/**
    https://leetcode.com/problems/range-sum-query-mutable/
    https://leetcode.com/problems/count-of-smaller-numbers-after-self/
    time: O(logn)
    space: O(n)
    线段树的节点数量大约是n + n/2 + n/4 + ... + 1 = 2n，所以空间复杂度是O(n)
 **/

public class SegmentTreeByNode {
    SegmentTreeNode root;

    public SegmentTreeByNode(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    /**
     * 递归 + 分治，根据nums创建Segment Tree
     * time: O(logn)
     * space: O(n)
     */
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }


        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        int mid = root.mid();
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid + 1, end);

        if (root.left != null) {
            root.sum += root.left.sum;
        }
        if (root.right != null) {
            root.sum += root.right.sum;
        }
        return root;
    }

    /**
     * 将index = i的元素更新为val
     * time: O(logn)
     * space: O(logn)
     */
    public void update(int i, int val) {
        update(root, i, val);
    }
    // 递归 + 分治找到所在区间
    private void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end && root.start == i) {
            root.sum = val;
            return;
        }

        int mid = root.mid();
        if (i <= mid) {
            update(root.left, i, val);
        } else {
            update(root.right, i , val);
        }

        int sum = 0;
        if (root.left != null) {
            sum += root.left.sum;
        }
        if (root.right != null) {
            sum += root.right.sum;
        }
        root.sum = sum;
    }

    /**
     * 返回[start, end]的元素之和
     * time: O(logn)
     */
    public int sumRange(int start, int end) {
        return sumRange(root, start, end);
    }
    // 递归 + 分治找到所在区间
    private int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.start >= start && root.end <= end) {
            return root.sum;
        }

        int mid = root.mid();
        if (start > mid) {
            return sumRange(root.right, start, end);
        } else if (end <= mid) {
            return sumRange(root.left, start, end);
        } else {
            return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
        }
    }

    public static void main(String[] args) {

    }
}

