class Solution {
    public static int max(int i,int j){
        return (i<j) ? j : i;
    }
    public static int min(int i,int j){
        return (i > j) ? j : i;
    }
    public int maxArea(int[] height) {
    //     int area =0;
    //     int i = 0;
    //     int j = height.length-1;
    // while(i<j){
    //             int c_area = min(height[i],height[j]) * (j-i);
    //             area =max(area,c_area);
                
    //         if (height[i] < height[j]) {
    //             i++;
    //         } else {
    //             j--;
    //         }
    //     }
    //     return area;


    int right = 0;
    int left = height.length -1;
    int maxArea = 0;

    while(right < left){
        maxArea = Math.max(maxArea, Math.min(height[left],height[right]) * (left - right));

        if(height[right] > height[left]) left--;
        else right++;
    }
    return maxArea;
    }
}