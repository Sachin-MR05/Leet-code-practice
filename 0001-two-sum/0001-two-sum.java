class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int i = 0;
        // int j =nums.length-1;
        // int[] result = new int[2];
        // Arrays.sort(nums);
        // while(i<j){
        //     if(nums[i]+nums[j]==target){
        //         result[0]=i;
        //         result[1]=j;
        //         return result;
        //     }
        //     if(nums[i] + nums[j] <= target){
     
        //         i++;
        //     }
        //     else j--;
        // }
        // return result;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};

    }
}