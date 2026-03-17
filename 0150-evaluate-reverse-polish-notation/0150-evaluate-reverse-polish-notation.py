class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        action = {"+": add, "-": sub, "*": mul, "/": truediv}
        stack = []
        for token in tokens:
            if token in action:
                stack[-1] = int(action[token](stack[-2], stack.pop()))    
            else:
                stack.append(int(token))
        return stack.pop()
        