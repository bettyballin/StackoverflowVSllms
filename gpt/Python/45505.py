from queue import Queue\n\nclass StackWithEfficientPush:\n    def __init__(self):\n        self.q1 = Queue()\n        self.q2 = Queue()\n\n    def push(self, x):\n        self.q1.put(x)\n\n    def pop(self):\n        if self.q1.empty():\n            return None\n        while self.q1.qsize() != 1:\n            self.q2.put(self.q1.get())\n        popped_element = self.q1.get()\n        self.q1, self.q2 = self.q2, self.q1\n        return popped_element\n\n    def isempty(self):\n        return self.q1.empty()\n\n    def size(self):\n        return self.q1.qsize()\n\n# Example usage:\nstack = StackWithEfficientPush()\nstack.push(1)\nstack.push(2)\nstack.push(3)\nprint(stack.pop())  # Output: 3\nprint(stack.pop())  # Output: 2