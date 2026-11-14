class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int max_l = 0;
        int max_f = 0;

        int[] freq = new int[26];

        while(r< s.length()){
            freq[s.charAt(r) - 'A']++;
            max_f = Math.max(max_f,freq[s.charAt(r)-'A']);

            while(r-l+1 - max_f > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            max_l = Math.max(max_l,r-l+1);
            r++;
        }
        return max_l;
    }
}