package array.longest_harmonious_subsequence;

import java.util.Arrays;

public class SlidingWindow {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[index] > 1) {
                index++;
            }
            if (nums[i] - nums[index] == 1) {
                maxLength = Math.max(maxLength, i - index + 1);
            }
        }
        return maxLength;
    }
}
