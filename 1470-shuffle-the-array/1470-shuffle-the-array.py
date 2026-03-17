class Solution(object):
    def shuffle(self, nums, n):
        l = []
        l1 = nums[:n]
        l2 = nums[n:]
        
        for i in range(n):
            l.append(l1[i])
            l.append(l2[i])
        
        return l
        