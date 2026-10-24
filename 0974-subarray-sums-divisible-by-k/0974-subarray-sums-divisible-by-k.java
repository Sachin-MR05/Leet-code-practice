class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count =0;
        int prefixsum =0;
        // for(int i =0; i < nums.length;i++){
        //     int sum = 0;
        //     for(int j =i;j <nums.length;j++){
        //         sum += nums[j];

        //         if(sum%k== 0){
        //             count++;
        //         }
        //     }
        // }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i : nums){
            prefixsum += i;
            int remainder = prefixsum % k;
            if(remainder<0) remainder +=k;
            if(map.containsKey(remainder)){
                count+= map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder,0)+1);

        }
        return count;
    }
}