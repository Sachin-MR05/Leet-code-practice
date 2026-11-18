class Solution {
    public int mySqrt(int x) {
         if(x==1) return 1;
        // for(int i = x/2;i>=1;i--){
        //     if(i*i <= x) return i;
        // }
        // return 0;


        long left = 1;
        long right = x;
        long ans  =0;

        while(left <= right){
            long mid = left + (right - left)/2;
            
            if(mid * mid == x) return (int) mid;
            else if(mid * mid < x) {ans = mid;
            left = mid +1;}
            else right = mid -1;
        }
    return (int) ans;
    }
}