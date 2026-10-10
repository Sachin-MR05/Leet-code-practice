class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int r =0;
        int l =0;
        int sum =0;
        int max =0;

        while(r<nums.length){
            sum +=nums[r];
            if(max==0 && sum>=target) max = r-l +1;
            while(sum >= target){
            max = Math.min(max,r-l+1);
            sum-=nums[l];
            l++;}
            r++;
        }
        return max;
    }
}