class Solution {
    public int secondHighest(String s) {
                int a =-1;
        int b =-1;
            for(int i =0;i< s.length();i++){
                
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    int n = c -'0';
                if(n> a){
                    b=a;
                    a=n;
                }
                else if(n<a && n>b){
                    b=n;
                }
                }
        }

        return b;
        
    }
}