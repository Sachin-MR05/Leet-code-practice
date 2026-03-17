class Solution:
    def findErrorNums(self, nums):
        n = len(nums)  # [1, 2, 2, 4]  # 4
        actual_sum = sum(nums)  # 1 + 2 + 2 + 4 = 9
        unique_sum = sum(set(nums))  # sum({1, 2, 4}) = 7
        expected_sum = n * (n + 1) // 2  # 4 * (5) // 2 = 10

        duplicate = actual_sum - unique_sum  # 9 - 7 = 2
        missing = expected_sum - unique_sum  # 10 - 7 = 3
        return [duplicate, missing]  # [2, 3]
        