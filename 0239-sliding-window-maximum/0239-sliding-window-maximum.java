class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int arr[] = new int[nums.length-k +1];

        Deque<Integer> dq = new ArrayDeque<>();

//BRUT FORCE:
        // for(int i =0;i<=nums.length-k;i++){
        //     int max =Integer.MIN_VALUE;

        //     for(int j =i; j< i+k; j++){
        //         max = Math.max(max, nums[j]);
        //     }
        //     list.add(max);
        // }
        // for(int i =0;i<list.size();i++){
        //     arr[i] = list.get(i);
        // }
        // return arr;
        int resIndex = 0;
        for(int i =0; i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst() <i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i >= k-1 ) arr[resIndex++] = nums[dq.peekFirst()];
        }
        return arr;
    }
}