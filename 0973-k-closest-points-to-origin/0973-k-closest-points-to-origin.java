class Solution {
    public static int getDistance(int[] arr){
        return  arr[0]*arr[0] + arr[1]*arr[1];
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> getDistance(b) - getDistance(a));

        for(int[] n: points){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] result = new int[k][];
        int i =0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll();
        }
        return result;
    }
}    