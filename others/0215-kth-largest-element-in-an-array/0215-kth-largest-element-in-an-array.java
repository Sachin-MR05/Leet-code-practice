import java.util.Arrays;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int num[] = Arrays.stream(nums).sorted().toArray();
        return num[num.length-k];
    }
}