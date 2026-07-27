class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i =0;i<numRows;i++){
            List<Integer> sublist = new ArrayList<>();
            for(int j =0;j<=i;j++){
                if(j ==0 || j == i){
                    sublist.add(1);
                }
                else{
                    List<Integer> newlist = list.get(i-1);
                    sublist.add(newlist.get(j)+newlist.get(j-1));
                }
            }
            list.add(sublist);
        }
        return list;
    }
}