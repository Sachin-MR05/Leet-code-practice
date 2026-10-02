class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int right = 0;
        int left =0;
        int max_length = 0;
        int max_freq = 0;
        while(right < n){
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            max_freq = Math.max(max_freq,freq[ch -'A']);

            while((right -left +1 )- max_freq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            max_length = Math.max(max_length,right - left +1);
            right++;
        }
    return max_length;
    }
}