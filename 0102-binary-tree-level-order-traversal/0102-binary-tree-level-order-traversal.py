# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import collections
class Solution(object):
    def levelOrder(self, root):
        res =[]
        q = collections.deque()
        if root:
            q.append(root)
        while q:
            qlen = len(q)
            level = []
            for i in range(qlen):
                node = q.popleft()
                level.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(level)
        return res        
                    

        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        