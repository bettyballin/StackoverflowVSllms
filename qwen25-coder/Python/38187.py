class DynamicArray:\n    def __init__(self):\n        self.capacity = 1\n        self.size = 0\n        self.array = [None] * self.capacity\n\n    def _resize(self, new_capacity):\n        new_array = [None] * new_capacity\n        for i in range(self.size):\n            new_array[i] = self.array[i]\n        self.array = new_array\n        self.capacity = new_capacity\n\n    def append(self, item):\n        if self.size == self.capacity:\n            self._resize(2 * self.capacity)\n        self.array[self.size] = item\n        self.size += 1\n\n    def __getitem__(self, index):\n        if not 0 <= index < self.size:\n            raise IndexError('Index out of bounds')\n        return self.array[index]\n\n    def __len__(self):\n        return self.size