class Solution {
    public int findDuplicate(int[] nums) {
    //     int n =0;
    //     for(int i =0;i< nums.length;i++){
    //         for(int j =i+1;j <nums. length;j++){
    //             if(nums[i]==nums[j]){
    //                 n = nums[i];
    //                 return n;
    //             }
    //         }
    //     }
    //    return n; 
    int fast = nums[0];
    int slow = nums[0];


    do{
        fast = nums[nums[fast]];
        slow = nums[slow];
    }while(fast != slow);
    slow = nums[0];

    while(slow != fast){
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
    }
}