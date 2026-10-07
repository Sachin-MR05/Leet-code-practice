class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] w_freq = new int[26];
        for(char ch : s1.toCharArray()){
            w_freq[ch - 'a']++;
        }
        int lim = 0;
        int l = 0;

        int[] s_freq = new int[26];

        for(int r =0; r<s2.length() ;r++){
            s_freq[s2.charAt(r) - 'a']++;

            if(r - l +1 > s1.length()){
                s_freq[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(w_freq,s_freq)){
                return true;
            }           
        }
        return false;
    }
}