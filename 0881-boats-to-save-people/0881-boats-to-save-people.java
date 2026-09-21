class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats =0 ;
        int left = 0;
        int right = people.length -1;
        Arrays.sort(people);
        while(left <= right){
            if(people[left]+ people[right] <= limit){
                
                left++;
            }boats++;
                right--;
            // else{
            //     boats++;
            //     right--;
            // }
        }
        return boats;
    }
}