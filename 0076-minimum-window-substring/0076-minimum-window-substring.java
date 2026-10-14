class Solution {
    public String minWindow(String s, String t) {
        int tl = t.length();
        Map<Character,Integer> map = new HashMap<>();

        for(Character ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count =0;
        int l =0;
        int si =0;
        int min = Integer.MAX_VALUE ;
        for(int r =0 ;r< s.length(); r++){
            if(map.containsKey(s.charAt(r))){
                if(map.get(s.charAt(r))>0){
                    count++;
                }
                map.put(s.charAt(r),map.get(s.charAt(r))-1);
            }
            while(count == tl){
                if(min > r-l+1){
                    min = r-l+1;
                    si =l;   
                }
                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l),map.get(s.charAt(l))+1);
                    if(map.get(s.charAt(l))>0) count--;
                }
                l++;
            }
        }
        if (min ==  Integer.MAX_VALUE) return "";
        return s.substring(si , si+min );
        
    }
}