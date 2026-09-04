class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j =nums.length-1;
        int[] result = new int[2];
        while(i<j){
            if(nums[i]+nums[j]==target){
                result[0]=i;
                result[1]=j;
                return result;
            }
            if(i==j-1){
                j--;
                i=0;
            }
            else i++;
        }
        return result;

    }
}