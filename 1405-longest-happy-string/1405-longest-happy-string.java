class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int c_a =0;
        int c_b = 0;
        int c_c = 0;

        StringBuilder sb = new StringBuilder();

        while(true){
            if(a > 0 && 
            ((a>=b && a>=c && c_a<2)||
            (a>=c && c_b >=2) ||
            (a>=b && c_c >=2))){
                a-=1;
                c_a +=1;
                c_b=0;
                c_c =0;
                sb.append('a');
            }
            else if(b > 0 && 
            ((b>=a && b>=c && c_b<2)||
            (b>=a && c_c >=2) ||
            (b>=c && c_a >=2))){
                b-=1;
                c_a =0;
                c_b+=1;
                c_c =0;
                sb.append('b');
            }
            else if(c > 0 && 
            ((c>=b && c>=a && c_c<2)||
            (c>=a && c_b >=2) ||
            (c>=b && c_a >=2))){
                c-=1;
                c_a =0;
                c_b=0;
                c_c +=1;
                sb.append('c');
            }
            else{
                break;
            }
        
        }
        return sb.toString();
    }
}