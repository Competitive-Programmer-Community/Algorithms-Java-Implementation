package Array;
// 10.05

// 1 classical binary search: find any/first/last index of target in nums
// 2 状态二分 OOXX：find first bad version X/last good version O
// 3 binary reduction：search in rotated sorted array(RSA), 保留一定有解的一半，去除可能没有解的另一半

public class BinarySearch {

    /**
     *  recursive binary search
     *  time: O(logn)
     *  space: O(logn)
     */
    public static int binarySearch_recursive(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (target > nums[mid]) {
            return binarySearch_recursive(nums, mid + 1, end, target);
        } else if (target < nums[mid]) {
            return binarySearch_recursive(nums, start, mid - 1, target);
        } else {
            return mid;
        }
    }

    /**
     * iterative binary search
     * time: O(logn)
     * space: O(1)
     */
    private static int binarySearch_iterative(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    /**
     * find the first n in nums that >= target, return its index
     * @param nums
     * @param target
     * @return
     */
    private static int findFirstIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] >= target) {
            return left;
        } else if (nums[right] >= target) {
            return right;
        } else {
            return -1;
        }
    }

    /**
     * find the last n in nums that <= target, return its index
     * @param nums
     * @param target
     * @return
     */
    private static int findLastIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (nums[right] <= target) {
            return right;
        } else if (nums[left] <= target) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 9, 10};
        System.out.println(binarySearch_recursive(nums, 0, nums.length - 1, 6));
        System.out.println(binarySearch_iterative(nums,6));
        System.out.println(findFirstIndex(nums, 6));
        System.out.println(findLastIndex(nums, 6));
    }
}
