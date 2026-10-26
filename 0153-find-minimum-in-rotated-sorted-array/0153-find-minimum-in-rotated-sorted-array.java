class Solution {
    public int findMin(int[] nums) {
        int left =0;
        int right = nums.length  -1;

        while(left < right){
            int piviot = left + (right - left) /2;

            if(nums[piviot]> nums[right] ) left = piviot + 1;

            else right = piviot;
        }

        return nums[left];
    }
}