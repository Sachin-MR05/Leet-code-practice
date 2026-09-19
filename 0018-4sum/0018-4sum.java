class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> Result = new HashSet<>();
        int length = nums.length;
        
        Arrays.sort(nums);
        for(int i =0;i<length-3;i++){
            for(int j =i+1;j<length -2;j++){
                int left = j+1;
                int right= length-1;

                while(left < right){
                    long sum = (long) nums[i]+nums[j]+ nums[left]+ nums[right];
                    if( sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        Result.add(list);
                    }

                    if(sum < target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
                
            }
        }
        return new ArrayList<>(Result);
    }
}