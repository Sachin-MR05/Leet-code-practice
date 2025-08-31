
class Solution(object):
    def productExceptSelf(self, nums):
        n = len(nums)
        r = [1]*n
        p = 1
        for i in range(n):
            r[i]*=p
            p*=nums[i]
        s = 1
        for i in range(n-1,-1,-1):
            r[i]*=s
            s*=nums[i]
        return r    
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        