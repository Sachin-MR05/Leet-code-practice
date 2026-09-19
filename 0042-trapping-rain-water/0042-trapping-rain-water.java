class Solution {
    public int trap(int[] height) {
        int water =0;
        int L_wall = 0;
        int R_wall = 0;
        int left = 0;
        int right = height.length-1;


        while(left<right){

            if(height[left] < height[right]){
            if(height[left] >= L_wall) {
            L_wall = height[left];
            }
            else {
            water += L_wall - height[left];
            }
            left++;
            }

            else{
            if(height[right] >= R_wall) {
            R_wall = height[right];
            }

            else {
            water += R_wall - height[right];
            }
            right--;
            }

        }
        return water;
    }
}