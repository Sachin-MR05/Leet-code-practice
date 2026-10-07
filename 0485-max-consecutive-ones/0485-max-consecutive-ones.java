class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int r =0;
        int l =0;
        int max = 0;
        while(r < nums.length){
            if(nums[r]!=1){
                l=r+1;
            }
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}