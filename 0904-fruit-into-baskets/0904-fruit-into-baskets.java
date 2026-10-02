class Solution {
    public int totalFruit(int[] fruits) {


       Set<Integer> hs = new HashSet<>();
       Map<Integer,Integer> hm = new HashMap<>();


       if(fruits.length ==2) return 2;
        int right = 0;
        int max = 0;
        int left =0;

        while(right < fruits.length){
            
            hm.put(fruits[right],hm.getOrDefault(fruits[right],0)+1);

            while(hm.size()>2){
                hm.put(fruits[left],hm.get(fruits[left])-1);
                if(hm.get(fruits[left])==0){
                    hm.remove(fruits[left]);
                }
                left++;
            }
        max = Math.max(max,right - left +1);
        right++;
        }
        return max;
    }
}