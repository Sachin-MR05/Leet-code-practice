class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int l =0;
        int r = k-1;
        double sum =0;
        double salary =0;

        for(int i =0;i<k;i++){
            sum+=nums[i];
        }
        salary = sum/k;
        while(r < nums.length-1){
            sum-= nums[l];
            r++;
            l++;
            sum+=nums[r];

            double csalary = sum/k;
            salary = Math.max(salary,csalary);
        }

       return salary;    
    }
}