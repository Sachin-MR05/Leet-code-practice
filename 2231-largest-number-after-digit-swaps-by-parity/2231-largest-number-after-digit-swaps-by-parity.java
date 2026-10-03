class Solution {
    public int largestInteger(int num) {
          PriorityQueue<Character> odd = new PriorityQueue<>(Collections.reverseOrder());
          PriorityQueue<Character> even = new PriorityQueue<>(Collections.reverseOrder());

          String str = ""+num;
          char[] arr = str.toCharArray();

        for(char ch:arr){
            int val = ch - '0';

            if(val%2 == 0) even.add(ch);
            else odd.add(ch);

        }
          StringBuilder result = new StringBuilder();

          for(char ch: arr){
            int val = ch -'0';

            if(val%2 == 0) result.append(even.poll());
            else result.append(odd.poll());
          }

          return Integer.parseInt(result.toString());
    }
}
