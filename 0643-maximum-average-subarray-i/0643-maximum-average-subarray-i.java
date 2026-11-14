class Solution {
    public double findMaxAverage(int[] nums, int k) {

    //     int l =0;
    //     int r = k-1;
    //     double sum =0;
    //     double salary =0;

    //     for(int i =0;i<k;i++){
    //         sum+=nums[i];
    //     }
    //     salary = sum;
    //     while(r < nums.length-1){
    //         sum-= nums[l];
    //         r++;
    //         l++;
    //         sum+=nums[r];

    //         double csalary = sum;
    //         salary = Math.max(salary,csalary);
    //     }

    //    return salary/k;  


    // int l = 0;
    // int r = k-1;
    // int n = nums.length;
    // double sum = 0;
    // for(int i =0;i<k;i++){
    //     sum+=nums[i];
    // }
    // double avg = sum/k;

    // while(r<n-1){
    //     sum-=nums[l];
    //     r++;
    //     l++;
    //     sum+=nums[r];
    //     avg =Math.max(avg,sum/k);
    // }

    int l =0;
    int r = 0;
    int sum =0;
    double max = Integer.MIN_VALUE;
    while(r<nums.length){
        sum+= nums[r];

        if(r-l+1 == k){
            max = Math.max(max,sum);
            sum-=nums[l];
            l++;
        }
        r++;
    }
    return max/k;
    }  
}