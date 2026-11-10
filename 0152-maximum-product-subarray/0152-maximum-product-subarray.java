class Solution {
    public int maxProduct(int[] nums) {
        int proud = 1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length;i++){
            proud = 1;
            for(int j = i;j<nums.length;j++){
                proud*= nums[j];
            
            max = Math.max(max , proud);
            }
            //if(proud < 1) proud = 1;
        }

        return max;
    }
}