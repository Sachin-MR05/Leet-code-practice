class Solution {
    public int longestOnes(int[] nums, int k) {
       int r =0;
       int l =0;
       int max =0;
       int zc = 0;
       while(r < nums.length){
        if(nums[r] != 1){
            zc++;
        }
        while(zc > k){
           
            if(nums[l]==0)zc--; 
            l++;
        }

        max  = Math.max(max , r-l +1);
        r++;
       } 
       return max;
    }
}