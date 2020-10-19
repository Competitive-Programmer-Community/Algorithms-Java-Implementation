package Tree.SegmentTree;


// 构造：O(logn)
// 查询：O(logn)
// 修改：O(logn)
// 线段树接近一个满二叉树

public class SegmentTreeByArray {
    private int[] segmentTree;
    private int length;

    public SegmentTreeByArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        segmentTree = new int[4 * nums.length];
        length = nums.length - 1;
        buildTree(nums, 0, nums.length - 1, 0);
    }

    // 将nums从start到end之间的数求和放入segmentTree[index]
    // time: O(logn)
    // space: O(n)
    // n is the len of nums
    private int buildTree(int[] nums, int start, int end, int index) {
        if (start == end) {
            segmentTree[index] = nums[start];
            return segmentTree[index];
        }

        int mid = start + (end - start) / 2;
        int left = buildTree(nums, start, mid, index * 2 + 1);
        int right = buildTree(nums, mid + 1, end, index * 2 + 2);
        segmentTree[index] = left + right;
        return segmentTree[index];
    }

    // time: O(logn)
    public void update(int i, int val) {
        update(0, length, 0, i, val);
    }

    private void update(int start, int end, int index, int i, int val) {
        if (start > end) {
            return;
        }
        if (start == end) {
            segmentTree[index] = val;
            return;
        }

        int mid = start + (end - start) / 2;
        if (i <= mid) {
            update(start, mid, index * 2 + 1, i, val);
        } else {
            update(mid + 1, end, index * 2 + 2, i, val);
        }

        segmentTree[index] = segmentTree[index * 2 + 1] + segmentTree[index * 2 + 2];
    }

    // time: O(logn)
    public int sumRange(int i, int j) {
        return sumRange(0, length, 0, i, j);
    }
    private int sumRange(int start, int end, int index, int i, int j) {
        // 当[start, end]在[i, j]内部时，返回sum[start, end]
        if (start >= i && end <= j) {
            return segmentTree[index];
        }

        int mid = start + (end - start) / 2;
        if (i > mid) {
            return sumRange(mid + 1, end, index * 2 + 2, i, j);
        } else if (j <= mid) {
            return sumRange(start, mid, index * 2 + 1, i, j);
        } else {
            return sumRange(start, mid, index * 2 + 1, i, j) + sumRange(mid + 1, end, index * 2 + 2, i, j);
        }
    }
}

