import java.util.Arrays;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //  nums = Arrays.stream(nums).sorted().toArray();
        // return nums[nums.length-k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : nums) pq.add(i);
        int num = 0;
        for(int i =0;i<k;i++){
            num = pq.poll();
        }

        return num;

    }
}