class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] sum = new int[nums.length];
        int[] result = new int[nums.length];
        int product = 1;
        int z = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0)
            product*=nums[i];
            if(nums[i]==0) z++;
        }
        if(z>1 || z>=nums.length) return result;
        for(int i =0;i<nums.length;i++){
            if(z==0)
            result[i]= product/nums[i];

            if(nums[i]==0){
                result[i]=product;
            }
            if(z>0 && nums[i]!=0)result[i]=0;

        }
        return result;
    }
}