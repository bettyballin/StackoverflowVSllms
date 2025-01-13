import time\nfrom collections import defaultdict\n\nclass RateLimiter:\n    def __init__(self, max_requests, time_window):\n        self.max_requests = max_requests\n        self.time_window = time_window\n        self.request_counts = defaultdict(list)\n\n    def is_allowed(self, ip_address):\n        now = time.time()\n        self.request_counts[ip_address] = [timestamp for timestamp in self.request_counts[ip_address] if timestamp > now - self.time_window]\n        if len(self.request_counts[ip_address]) < self.max_requests:\n            self.request_counts[ip_address].append(now)\n            return True\n        else:\n            return False\n\n# Example usage\nlimiter = RateLimiter(max_requests=100, time_window=60)  # 100 requests per minute\nif limiter.is_allowed('192.168.1.1'):\n    # Process the request\nelse:\n    # Handle the DOS attack