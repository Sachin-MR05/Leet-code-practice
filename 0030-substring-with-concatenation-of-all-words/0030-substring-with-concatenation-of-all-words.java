class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int al = words.length;
        int sl = words[0].length();

        Map<String,Integer> map = new HashMap<>();


        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
for(int offset =0; offset <sl; offset++){
        Map<String, Integer> check = new HashMap<>();
        int l = offset;
        int r = offset;
        int count =0;

        while(r+sl<=s.length()){

            String str = s.substring(r,r+sl);

            if(map.containsKey(str)){
                check.put(str,check.getOrDefault(str,0)+1);
                count++;
            

            while (check.get(str)> map.get(str)) {
                String first = s.substring(l,l+sl);
                check.put(first,check.get(first)-1);
                l+=sl;
                count--;
            }
            
            if (count == al) {
                res.add(l);
            }
            }
            else{
                count =0;
                l=r+sl;
                check.clear();
            }
            r+=sl;
        }
        //check.clear();
}
        return res;
    }
}