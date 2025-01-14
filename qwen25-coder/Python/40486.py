class TreeNode:\n    def __init__(self, key):\n        self.key = key\n        self.left = None\n        self.right = None\n        self.height = 1\n\nclass AVLTree:\n    def insert(self, root, key):\n        if not root:\n            return TreeNode(key)\n        elif key < root.key:\n            root.left = self.insert(root.left, key)\n        else:\n            root.right = self.insert(root.right, key)\n\n        root.height = 1 + max(self.getHeight(root.left),\n                           self.getHeight(root.right))\n\n        balance = self.getBalance(root)\n\n        if balance > 1 and key < root.left.key:\n            return self.rightRotate(root)\n\n        if balance < -1 and key > root.right.key:\n            return self.leftRotate(root)\n\n        if balance > 1 and key > root.left.key:\n            root.left = self.leftRotate(root.left)\n            return self.rightRotate(root)\n\n        if balance < -1 and key < root.right.key:\n            root.right = self.rightRotate(root.right)\n            return self.leftRotate(root)\n\n        return root\n\n    def leftRotate(self, z):\n        y = z.right\n        T2 = y.left\n        y.left = z\n        z.right = T2\n        z.height = 1 + max(self.getHeight(z.left),\n                           self.getHeight(z.right))\n        y.height = 1 + max(self.getHeight(y.left),\n                           self.getHeight(y.right))\n        return y\n\n    def rightRotate(self, z):\n        y = z.left\n        T3 = y.right\n        y.right = z\n        z.left = T3\n        z.height = 1 + max(self.getHeight(z.left),\n                           self.getHeight(z.right))\n        y.height = 1 + max(self.getHeight(y.left),\n                           self.getHeight(y.right))\n        return y\n\n    def getHeight(self, root):\n        if not root:\n            return 0\n        return root.height\n\n    def getBalance(self, root):\n        if not root:\n            return 0\n        return self.getHeight(root.left) - self.getHeight(root.right)\n\n# Example usage:\navl_tree = AVLTree()\nroot = None\nkeys = [30, 20, 40, 10, 50, 25]\nfor key in keys:\n    root = avl_tree.insert(root, key)