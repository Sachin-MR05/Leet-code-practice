class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int length = 0;
        int clength =0;
        int j =0;
        for(int i =0;i<s.length(); i++){

            char ch = s.charAt(i);
            while(set.contains(ch)){
                set.remove(s.charAt(j));
                j++;

            }
            clength = i - j +1;
            set.add(ch);
            length = Math.max(length,clength);

        }

        return length;
    }
}