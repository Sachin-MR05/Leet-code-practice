class Solution {
    public int pivotIndex(int[] nums) {

    int total = 0;
    int left =0;
    int right =0;
    for(int n : nums){
        total += n;
    }
    // for(int i =0;i<nums.length;i++){
    //    for(int j =0;j<i;j++){
    //     lsum += nums[j];
    //    }
    //    for(int j =i+1;j<nums.length;j++){
    //     rsum += nums[j];
    //    }

    //    if (rsum == lsum) return i;
        
    // }

    for(int i =0;i<nums.length;i++){
  
        right = total - left - nums[i];

        if(right == left){
            return i;
        }
        left += nums[i];
    }

    return -1;
    }
}