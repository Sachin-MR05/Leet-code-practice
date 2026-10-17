class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = check(nums, target,true);
        res[1] = check(nums,target,false);
        
        
        return res;

    }

    public static int check(int[] nums, int target, boolean isFirst){
        int left = 0;
        int right = nums.length -1;
        int bound = -1;

        while(left <= right){
            int mid = left + (right - left +1)/2;

            if(nums[mid] == target){
                bound = mid;
                if(isFirst){
                    
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid -1;
            }

        }
        return bound;
    }
}