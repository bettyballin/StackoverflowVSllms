class AttractionsQueue:\n    def __init__(self):\n        self.standard_queue = []\n        self.fastpass_queue = {}\n    \n    def add_to_standard(self, visitor):\n        self.standard_queue.append(visitor)\n    \n    def add_fastpass(self, visitor, time_block):\n        if time_block not in self.fastpass_queue:\n            self.fastpass_queue[time_block] = []\n        self.fastpass_queue[time_block].append(visitor)\n    \n    def serve_next_visitor(self, current_time):\n        # Serve from fastpass queue first if available\n        if current_time in self.fastpass_queue and len(self.fastpass_queue[current_time]) > 0:\n            return self.fastpass_queue[current_time].pop(0)\n        elif len(self.standard_queue) > 0:\n            return self.standard_queue.pop(0)\n        else:\n            return None\n\n# Example usage\nattractions = AttractionsQueue()\nattractions.add_to_standard("Visitor 1")\nattractions.add_fastpass("Visitor 2", "14:00-16:00")\nprint(attractions.serve_next_visitor("13:59"))  # Serve Visitor 1\nprint(attractions.serve_next_visitor("14:00"))  # Serve Visitor 2