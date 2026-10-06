class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();

        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? 
              b.getKey().compareTo(a.getKey()) : 
              a.getValue() - b.getValue());

        for(Map.Entry<String,Integer> entry : map.entrySet()){

            pq.add(entry);

            if(pq.size()> k) pq.poll();

        }
        String[] result = new String[k];

        while(!pq.isEmpty()){
            result[--k] = pq.poll().getKey();
        }
        return Arrays.asList(result);
    }
}