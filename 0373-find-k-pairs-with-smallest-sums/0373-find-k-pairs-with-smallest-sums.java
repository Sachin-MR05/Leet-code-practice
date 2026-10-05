class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        List<List<Integer>> list = new ArrayList<>();

        for(int i =0;i<Math.min(nums1.length,k);i++){
            int sum = nums1[i]+nums2[0];
            pq.add(new int[]{sum,i,0});
        }

        while(k>0){
            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];

            list.add(Arrays.asList(nums1[i],nums2[j]));

            k--;

            if(j+1< nums2.length){
                int sum = nums1[i]+nums2[j+1];
                pq.add(new int[]{sum,i,j+1});
            }
        }
        return list;
    }
}