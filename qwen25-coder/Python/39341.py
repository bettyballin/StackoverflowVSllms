class ObjectSet:\n    def __init__(self):\n        self.by_string = {}  # Maps string key to object\n        self.by_ordinal = {}  # Maps ordinal to object\n        self._count = 0\n\n    def add_object(self, obj, string_key, ordinal):\n        if string_key in self.by_string or ordinal in self.by_ordinal:\n            raise ValueError("This object already exists in the set.")\n        \n        self.by_string[string_key] = obj\n        self.by_ordinal[ordinal] = obj\n        self._count += 1\n\n        # Process further based on new count...\n        self.process_new_count(self._count)\n\n    def process_new_count(self, count):\n        print(f"New object added. Total objects: {count}")\n\n    def get_size(self):\n        return self._count\n\n# Example usage:\nobj_set = ObjectSet()\nobj_set.add_object("object1", "key1", 0)