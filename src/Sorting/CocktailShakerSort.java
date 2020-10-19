package Sorting;

// a variance of bubble sort
// bidirectional bubble sort
// time: O(n^2)
// space: O(1)
// 稳定性排序算法
import java.util.Arrays;

public class CocktailShakerSort {
    public static void cocktailShakerSort(int[] nums) {

        boolean swaped = true;
        int start = 0, end = nums.length - 1;

        while(swaped) {
            swaped = false;
            for (int i = start; i < end; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swaped = true;
                }
            }

            if (!swaped) {
                break;
            }

            end -= 1;
            swaped = false;
            for (int i = end; i > start; i--) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    swaped = true;
                }
            }

            if (!swaped) {
                break;
            }

            start += 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 81, 84, 23, 63, 57, 16, 25, 63, 40};
        cocktailShakerSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
