class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
    //    int sum =0;
    //    int i =0;
    //    HashSet<Integer> set = new HashSet<>();
    //    int lim =0;
    //    while(i<nums.length && set.size() < k){
    //         if(!set.contains(nums[i])){
    //         sum+=nums[i];
    //         }
    //         set.add(nums[i]);
    //         i++;
    //    }
    //    if(set.size()<k) sum =0; 
    //    int max =sum;
    //    int r = i ,l = i-k;
    

    //    while(r<nums.length){
    //     if(!set.contains(nums[r])){
    //     sum -= nums[l];
    //     set.remove(nums[l]);
    //     l++;
    //     sum += nums[r];
    //     set.add(nums[r]);
    //     max = Math.max(max,sum);
    //     }
    //     r++;
    //    }
    //    return max;

    HashSet<Integer> set = new HashSet<>();
    long sum = 0;
    long max =0;

    int l =0;

    for(int r =0; r < nums.length; r++){

        while(set.contains(nums[r])){
            set.remove(nums[l]);
            sum -= nums[l];
            l++;
        }

        set.add(nums[r]);
        sum+=nums[r];

        if(r-l+1>k){
            sum-=nums[l];
            set.remove(nums[l]);
            l++;
        }
        if(r - l + 1 == k && set.size() == k)
        max = Math.max(max,sum);
    }
    return max;
    }
}