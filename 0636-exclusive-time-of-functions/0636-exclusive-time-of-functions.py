class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0] * n
        stack = []

        prev = 0 # to store start time of recent funciton

        for i in range(len(logs)):
            iden, status, time_stamp = logs[i].split(":")
            iden = int(iden)
            time_stamp = int(time_stamp)
            
            if status == "start":
                if stack: # if there is already a fucntion running
                    top = stack[-1]
                    res[top] += time_stamp - prev

                stack.append(iden)
                prev = time_stamp
            else:
                top = stack.pop()

                res[top] += time_stamp - prev + 1 # +1 as it is  exclusive

                prev = time_stamp + 1 # +1 for same reason
        return res
               
        