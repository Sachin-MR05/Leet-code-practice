class Solution(object):
    def groupAnagrams(self, strs):
        a ={}
        for i in strs:
            k = "".join(sorted(i))
            if k not in a:
                a[k]=[]
            a[k].append(i)
        return list(a.values())      

           

        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        