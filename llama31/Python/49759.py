class Node:\n    def __init__(self, value, left=None, right=None):\n        self.value = value\n        self.left = left\n        self.right = right\n        self.original_state = None\n        self.swapped = False\n\ndef permute_tree(node):\n    if node is None:\n        return\n\n    if node.left is None and node.right is None:\n        # If the node is a leaf, there's nothing to permute\n        return\n\n    if node.left is not None and node.right is not None:\n        # If both children exist, try to permute the left subtree\n        if not node.left.swapped:\n            permute_tree(node.left)\n        else:\n            # If the left subtree has been fully swapped, swap the right child with the left child's right child\n            node.right, node.left.right = node.left.right, node.right\n            node.left.swapped = False\n\n        # If we're back to the original state, swap the right child with the lowest left node's right child\n        if node.original_state is not None and node.value == node.original_state:\n            lowest_left = find_lowest_left(node.left)\n            node.right, lowest_left.right = lowest_left.right, node.right\n            lowest_left.left, lowest_left.right = lowest_left.right, lowest_left.left\n            node.left.swapped = False\n            node.left.original_state = node.left.value\n            node.swapped = True\n\n    elif node.left is not None:\n        # If only the left child exists, try to permute it\n        permute_tree(node.left)\n\n    elif node.right is not None:\n        # If only the right child exists, there's nothing to permute\n        pass\n\ndef find_lowest_left(node):\n    while node.left is not None:\n        node = node.left\n    return node\n\n# Example usage:\nroot = Node("branch")\nroot.left = Node("branch")\nroot.right = Node("3")\nroot.left.left = Node("branch")\nroot.left.right = Node("2")\nroot.left.left.left = Node("0")\nroot.left.left.right = Node("1")\n\nwhile not root.swapped:\n    permute_tree(root)\n    print_tree(root)\n    print()\n\ndef print_tree(node, level=0):\n    if node is not None:\n        print_tree(node.right, level + 1)\n        print("  " * level + str(node.value))\n        print_tree(node.left, level + 1)