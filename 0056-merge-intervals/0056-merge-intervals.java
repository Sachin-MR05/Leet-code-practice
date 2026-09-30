class Solution {
    public int[][] merge(int[][] intervals) {
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));      
        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> arr = new ArrayList<>();
        int length = intervals.length;
  for(int i =1;i<length;i++){
            if(end >= intervals[i][0] ){
                if(end<intervals[i][1])
                end = intervals[i][1];

            }
            else{
                int[] res = {start,end};
                arr.add(res);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[] res = {start,end};
        arr.add(res);
        return arr.toArray(new int[arr.size()][]);
    }
}