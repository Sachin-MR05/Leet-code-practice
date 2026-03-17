class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        countList=[0]*(101)
        for num in nums:
            countList[num]+=1
        output=[]
        for num in nums:
            output.append(sum(countList[:num]))
        return output