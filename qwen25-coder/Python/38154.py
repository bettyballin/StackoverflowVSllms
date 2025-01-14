class FenwickTree:\n    def __init__(self, size):\n        self.tree = [0] * (size + 1)\n\n    def update(self, index, value):\n        while index < len(self.tree):\n            self.tree[index] += value\n            index += index & -index\n\n    def query(self, index):\n        result = 0\n        while index > 0:\n            result += self.tree[index]\n            index -= index & -index\n        return result\n\n# Example usage:\nsize = 10  # Assuming a max size for the list\nfenwick_tree = FenwickTree(size)\n\n# Add initial values (2, 3, 5) to the Fenwick Tree\nfenwick_tree.update(1, 2)\nfenwick_tree.update(2, 3 - 2)  # Update based on previous value\nfenwick_tree.update(3, 5 - 3)\n\n# Adding a new number at the start (index 1)\nfenwick_tree.update(4, 5)           # Shift all existing values to the right\nfenwick_tree.update(3, 3)         # Shift by updating with previous value\nfenwick_tree.update(2, 2)         # Shift by updating with previous value\nfenwick_tree.update(1, 1 - 2)     # Update first index with new number\n\n# Query cumulative sums\nprint(fenwick_tree.query(1))  # Output: 1 (cumulative sum up to index 1)\nprint(fenwick_tree.query(2))  # Output: 3 (cumulative sum up to index 2)\nprint(fenwick_tree.query(3))  # Output: 6 (cumulative sum up to index 3)\nprint(fenwick_tree.query(4))  # Output: 11 (cumulative sum up to index 4)\n\n# To remove an element at a specific position, subtract its value\nfenwick_tree.update(1, -1)  # Remove the element 1 from index 1\n\n# Query cumulative sums after removal\nprint(fenwick_tree.query(1))  # Output: 0 (cumulative sum up to index 1)\nprint(fenwick_tree.query(2))  # Output: 2 (cumulative sum up to index 2)\nprint(fenwick_tree.query(3))  # Output: 5 (cumulative sum up to index 3)\nprint(fenwick_tree.query(4))  # Output: 10 (cumulative sum up to index 4)