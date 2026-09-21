class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(mid,low,nums);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(mid,high, nums);
                high--;
            }
        }
    }
    public static void swap(int l, int m ,int[] nums){
        int temp = nums[l];
        nums[l] = nums[m];
        nums[m] = temp;
    }
}