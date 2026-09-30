class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i =0;
        while(i<n  && intervals[i][1] < newInterval[0]){
            result.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }
        result.add(new int[]{newInterval[0],newInterval[1]});
        while(i<n){
            result.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        return  result.toArray(new int[result.size()][]);
    }
}