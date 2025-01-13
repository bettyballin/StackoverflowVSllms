class PCG:\n    def __init__(self, seed, n):\n        self.state = seed\n        self.n = n\n        self.multiplier = 6364136223846793005\n        self.increment = 1442695040888963407\n\n    def next(self):\n        self.state = self.state * self.multiplier + self.increment\n        return self.state\n\n    def random(self):\n        return (self.next() >> 32) % self.n\n\ndef generate_shuffled_range(seed, n):\n    pcg = PCG(seed, n)\n    output = set()\n    while len(output) < n:\n        value = pcg.random()\n        if value not in output:\n            output.add(value)\n            yield value\n\n# Example usage:\nseed = 123456789\nn = 10\nfor value in generate_shuffled_range(seed, n):\n    print(value)