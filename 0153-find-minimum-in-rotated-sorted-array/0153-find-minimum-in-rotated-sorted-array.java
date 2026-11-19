class Solution {
    public int findMin(int[] nums) {
        // int left =0;
        // int right = nums.length  -1;

        // while(left < right){
        //     int piviot = left + (right - left) /2;

        //     if(nums[piviot]> nums[right] ) left = piviot + 1;

        //     else right = piviot;
        // }

        // return nums[left];


        int left = 0;
        int right = nums.length - 1;

        int mid = 0;

        while(left < right){
            mid = left + (right - left)/2;

            if(nums[mid] > nums[right]) left = mid+1;
            else right = mid;

        }
            return nums[left];
    }
}