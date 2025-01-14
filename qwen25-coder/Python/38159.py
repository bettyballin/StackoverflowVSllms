class Processor:\n    def __init__(self, id):\n        self.id = id\n        self.state = {}\n\n    def receive_message(self, message):\n        # Process the incoming message\n        pass\n\n    def send_message(self, receiver_id, data):\n        # Simulate sending a message to another processor\n        print(f"Processor {self.id} sends {data} to Processor {receiver_id}")\n\nclass DistributedSystem:\n    def __init__(self, processors):\n        self.processors = {p.id: p for p in processors}\n\n    def step(self):\n        # Perform one round of communication or computation\n        pass\n\n# Example usage\nprocessor1 = Processor(1)\nprocessor2 = Processor(2)\n\nsystem = DistributedSystem([processor1, processor2])\nprocessor1.send_message(processor2.id, {"key": "value"})