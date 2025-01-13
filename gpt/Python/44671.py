class DynamicArray:\n    def __init__(self):\n        self.array = [None]\n        self.size = 0\n        self.capacity = 1\n\n    def append(self, value):\n        if self.size == self.capacity:\n            self._resize()\n        self.array[self.size] = value\n        self.size += 1\n\n    def _resize(self):\n        self.capacity *= 2\n        new_array = [None] * self.capacity\n        for i in range(self.size):\n            new_array[i] = self.array[i]\n        self.array = new_array\n\n# Usage\ndynamic_array = DynamicArray()\nfor i in range(1000):\n    dynamic_array.append(i)