class Solution(object):
    def topKFrequent(self, nums, k):
        f = {}
        for i in nums:
            f[i]=f.get(i,0)+1
        sf = sorted(f.items(), key=lambda x: x[1], reverse=True)
   
        return [x[0] for x in sf[:k] ]
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        