class MyObject:\n    def __init__(self, value):\n        self.value = value\n\ndef magic(left, op, right):\n    print(f"{left} {op} {right}")\n\n# Create instances of MyObject\nobj1 = MyObject(5)\nobj2 = MyObject(5)\n\n# Pass the objects to the function\nmagic(obj1, "==", obj2)