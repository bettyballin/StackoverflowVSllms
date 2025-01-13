class TreeNode:\n    def __init__(self, x):\n        self.val = x\n        self.left = None\n        self.right = None\n\ndef isSameShape(p, q):\n    if p is None and q is None:\n        return True\n    if p is None or q is None:\n        return False\n    return isSameShape(p.left, q.left) and isSameShape(p.right, q.right)