class AVLNode:\n    def __init__(self, key, height=1):\n        self.key = key\n        self.height = height\n        self.left = None\n        self.right = None\n\nclass AVLTree:\n    def insert(self, root, key):\n        if not root:\n            return AVLNode(key)\n        elif key < root.key:\n            root.left = self.insert(root.left, key)\n        else:\n            root.right = self.insert(root.right, key)\n\n        root.height = 1 + max(self.get_height(root.left), self.get_height(root.right))\n        balance = self.get_balance(root)\n\n        if balance > 1 and key < root.left.key:\n            return self.right_rotate(root)\n        if balance < -1 and key > root.right.key:\n            return self.left_rotate(root)\n        if balance > 1 and key > root.left.key:\n            root.left = self.left_rotate(root.left)\n            return self.right_rotate(root)\n        if balance < -1 and key < root.right.key:\n            root.right = self.right_rotate(root.right)\n            return self.left_rotate(root)\n        \n        return root\n\n    def delete(self, root, key):\n        if not root:\n            return root\n        elif key < root.key:\n            root.left = self.delete(root.left, key)\n        elif key > root.key:\n            root.right = self.delete(root.right, key)\n        else:\n            if root.left is None:\n                temp = root.right\n                root = None\n                return temp\n            elif root.right is None:\n                temp = root.left\n                root = None\n                return temp\n            temp = self.get_min_value_node(root.right)\n            root.key = temp.key\n            root.right = self.delete(root.right, temp.key)\n        \n        if root is None:\n            return root\n\n        root.height = 1 + max(self.get_height(root.left), self.get_height(root.right))\n        balance = self.get_balance(root)\n\n        if balance > 1 and self.get_balance(root.left) >= 0:\n            return self.right_rotate(root)\n        if balance > 1 and self.get_balance(root.left) < 0:\n            root.left = self.left_rotate(root.left)\n            return self.right_rotate(root)\n        if balance < -1 and self.get_balance(root.right) <= 0:\n            return self.left_rotate(root)\n        if balance < -1 and self.get_balance(root.right) > 0:\n            root.right = self.right_rotate(root.right)\n            return self.left_rotate(root)\n        \n        return root\n\n    def left_rotate(self, z):\n        y = z.right\n        T2 = y.left\n        y.left = z\n        z.right = T2\n        z.height = 1 + max(self.get_height(z.left), self.get_height(z.right))\n        y.height = 1 + max(self.get_height(y.left), self.get_height(y.right))\n        return y\n\n    def right_rotate(self, z):\n        y = z.left\n        T3 = y.right\n        y.right = z\n        z.left = T3\n        z.height = 1 + max(self.get_height(z.left), self.get_height(z.right))\n        y.height = 1 + max(self.get_height(y.left), self.get_height(y.right))\n        return y\n\n    def get_height(self, root):\n        if not root:\n            return 0\n        return root.height\n\n    def get_balance(self, root):\n        if not root:\n            return 0\n        return self.get_height(root.left) - self.get_height(root.right)\n\n    def get_min_value_node(self, root):\n        if root is None or root.left is None:\n            return root\n        return self.get_min_value_node(root.left)