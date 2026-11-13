class Solution {
    public int maxProduct(int[] nums) {
        // int proud = 1;
        // int max = Integer.MIN_VALUE;

        // for(int i = 0; i<nums.length;i++){
        //     proud = 1;
        //     for(int j = i;j<nums.length;j++){
        //         proud*= nums[j];
            
        //     max = Math.max(max , proud);
        //     }
        //     //if(proud < 1) proud = 1;
        // }

        // return max;


        int max = Integer.MIN_VALUE;
        int suffix =1;
        int preffix =1;
        for(int i =0;i<nums.length;i++){
            if(suffix == 0) suffix = 1;
            if(preffix == 0) preffix = 1;  

            preffix *= nums[i];
            suffix *= nums[nums.length-1-i];

            max = Math.max(max,Math.max(preffix,suffix));
        }
        return max;
    }
}