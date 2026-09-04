class Solution {
    public int removeDuplicates(int[] nums) {
        int result[] = new int[nums.length];
        int j =nums[0];
        int k =1;
        //result[k++]=j;
        for(int i =1;i<nums.length;i++){
            if(j!=nums[i]){
                j=nums[i];
                nums[k++] =j;
                
            }
        }
        return k;
    }
}