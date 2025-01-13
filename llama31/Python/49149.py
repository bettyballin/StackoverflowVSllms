class OnlineStats:\n    def __init__(self):\n        self.count = 0\n        self.mean = 0.0\n        self.m2 = 0.0\n\n    def update(self, x):\n        self.count += 1\n        delta = x - self.mean\n        self.mean += delta / self.count\n        self.m2 += delta * (x - self.mean)\n\n    def std_dev(self):\n        return math.sqrt(self.m2 / self.count)