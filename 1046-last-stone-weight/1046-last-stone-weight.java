class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n:stones){
            heap.add(n);
        }


        while(heap.size()>1){
            int first = heap.poll();
            int second = heap.poll();

            if(first> second){
                int temp = first-second;
                heap.add(temp);
            }
        }

        return heap.size()==0 ? 0 : heap.poll();
    }
}