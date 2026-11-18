class Solution {
    static int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0;i<s.length();i++){

            palCount(s,i,i);
            palCount(s,i,i+1);            
        }
        int num = count;
        count = 0;
        return num;
    }

    static void palCount(String s, int l,int r){
        while(l>=0 && r<s.length() &&  s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
    }
}