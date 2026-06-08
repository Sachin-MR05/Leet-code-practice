import java.util.Arrays;
class Solution {
    public int findKthLargest(int[] nums, int k) {
         nums = Arrays.stream(nums).sorted().toArray();
        return nums[nums.length-k];
    }
}