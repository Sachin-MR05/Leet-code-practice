class Solution {
    public String longestPalindrome(String s) {
        // int max = 0;
        // String res = "";
        // for(int i = 0;i<s.length();i++){
        //     for(int j = s.length()-1;j>=i;j--){

        //         int l = i;
        //         int r = j;
        //         boolean isTrue = true;
        //         while(l<r){
        //             if(s.charAt(l) != s.charAt(r)) isTrue = false;
        //             l++;
        //             r--;
        //         }

        //         if(isTrue && max < j-i+1) {   
        //             max = j-i+1;
        //             res = s.substring(i,j+1);
        //         }

        //     }
        // }
        // return res;
        int  start = 0 ,end = 0;

        for(int i =0;i<s.length();i++){
            int len1= palLength(s,i,i);
            int len2= palLength(s,i,i+1);

            int len = Math.max(len1,len2);

            if(len > (end - start)){
                start = i -( len-1)/2;
                end = i+ len/2;
            }
        }
        return s.substring(start,end+1);
        
    }

    static int palLength(String s , int l,int r){
        while(l>=0 && r<s.length() && s.charAt(r)==s.charAt(l)){
            l--;
            r++;
        }

        return r-l-1;
    }
}