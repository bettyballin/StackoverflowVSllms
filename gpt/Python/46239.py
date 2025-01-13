import heapq\n\nclass OnlineMedian:\n    def __init__(self):\n        self.lower_half = []  # Max-heap (invert values to simulate max-heap)\n        self.upper_half = []  # Min-heap\n\n    def add_num(self, num):\n        if len(self.lower_half) == 0 or num <= -self.lower_half[0]:\n            heapq.heappush(self.lower_half, -num)\n        else:\n            heapq.heappush(self.upper_half, num)\n\n        # Balance the heaps\n        if len(self.lower_half) > len(self.upper_half) + 1:\n            heapq.heappush(self.upper_half, -heapq.heappop(self.lower_half))\n        elif len(self.upper_half) > len(self.lower_half):\n            heapq.heappush(self.lower_half, -heapq.heappop(self.upper_half))\n\n    def find_median(self):\n        if len(self.lower_half) == len(self.upper_half):\n            return (-self.lower_half[0] + self.upper_half[0]) / 2.0\n        else:\n            return -self.lower_half[0]\n\n# Example usage\nonline_median = OnlineMedian()\nvalues = [1, 3, 4, 2, 5]\nfor v in values:\n    online_median.add_num(v)\n    print("Current median:", online_median.find_median())