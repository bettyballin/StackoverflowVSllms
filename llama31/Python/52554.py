import mmh3\nimport bitarray\n\nclass BloomFilter:\n    def __init__(self, size, hash_functions):\n        self.size = size\n        self.hash_functions = hash_functions\n        self.bit_array = bitarray.bitarray(size)\n        self.bit_array.setall(0)\n\n    def add(self, element):\n        for seed in range(self.hash_functions):\n            index = mmh3.hash(element, seed) % self.size\n            self.bit_array[index] = 1\n\n    def lookup(self, element):\n        for seed in range(self.hash_functions):\n            index = mmh3.hash(element, seed) % self.size\n            if self.bit_array[index] == 0:\n                return False\n        return True