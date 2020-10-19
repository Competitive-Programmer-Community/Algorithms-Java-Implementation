package Array;

import java.util.ArrayList;
import java.util.List;

/**
    find all the elements that appear more than n / k times in the array
    we can know that there will be less than k elements in the array of size = n

    https://leetcode.com/problems/majority-element/
    time: O(n)
    space: O(1)

    note: 当数据量很大时，可以使用MapReduce分布式计算，并行运行Boyer-Moore Algorithm
 **/

public class MooreVoting {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        int x = 0, counter1 = 0, y = 0, counter2 = 0, z = 0, counter3 = 0;
        for (int num: nums) {
            if (x == num) {
                counter1++;
            } else if (y == num) {
                counter2++;
            } else if (z == num) {
                counter3++;
            } else if (counter1 == 0) {
                x = num;
                counter1++;
            } else if (counter2 == 0) {
                y = num;
                counter2++;
            } else if (counter3 == 0) {
                z = num;
                counter3++;
            } else {
                counter1--;
                counter2--;
                counter3--;
            }
        }

        counter1 = 0;
        counter2 = 0;
        counter3 = 0;
        for (int num: nums) {
            if (x == num) {
                counter1++;
            } else if (y == num) {
                counter2++;
            } else if (z == num) {
                counter3++;
            }
        }

        if (counter1 * 4 > nums.length) {
            ans.add(x);
        }
        if (counter2 * 4 > nums.length) {
            ans.add(y);
        }
        if (counter3 * 4 > nums.length) {
            ans.add(z);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 1, 3, 5, 1, 1, 1, 1};
        System.out.println(majorityElement(nums));
    }
}
