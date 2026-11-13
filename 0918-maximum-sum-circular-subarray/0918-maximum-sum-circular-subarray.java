class Solution {
    public int maxSubarraySumCircular(int[] nums) {
          int index = 0;
          int max = nums[0],min = nums[0];
          int maxsum = nums[0],minsum = nums[0];
          int total = nums[0];
          for(int i =1;i<nums.length;i++){

            maxsum = Math.max(maxsum +nums[i],nums[i]);
            max = Math.max(max,maxsum);

            minsum = Math.min(minsum +nums[i],nums[i]);
            min = Math.min(min,minsum);

            total += nums[i];
          }
          if(max < 0) return max;
          return Math.max(total - min, max);
    }
}