class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        List<Integer> result =new  ArrayList<>();

        int[] pf = new int[26];

        for(char ch : p.toCharArray()){
            pf[ch-'a']++;
        }

        for(int i = 0;i<=slen-plen;i++){
            int[] sf = new int[26];

            for(int j =i; j< i+ plen;j++){
                sf[s.charAt(j) - 'a']++;
            }
            if(Arrays.equals(pf,sf)){
                result.add(i);
            }
        }
        return result;
    }
}