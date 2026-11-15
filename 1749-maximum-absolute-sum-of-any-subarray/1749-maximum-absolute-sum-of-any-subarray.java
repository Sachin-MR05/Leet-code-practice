class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // int max = nums[0];
        // int min = nums[0];
    //    for(int i =0;i<nums.length;i++){
    //     int sum = 0;
    //     for(int j = i;j<nums.length;j++){
    //         sum += nums[j];
    //         max = Math.max(max,Math.abs(sum));
    //     }
    //    }
        int s = 0, min = 0, max = 0;
        for (int a: nums) {
            s += a;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return max<0?(-min):min>0?max:max-min;
    }
}