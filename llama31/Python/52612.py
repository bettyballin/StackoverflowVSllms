import heapq\n\nclass Banner:\n    def __init__(self, id, score):\n        self.id = id\n        self.score = score\n\nclass BannerRotationSystem:\n    def __init__(self):\n        self.banners = []\n\n    def add_banner(self, banner):\n        heapq.heappush(self.banners, (banner.score, banner))\n\n    def rotate_banners(self):\n        top_banner = heapq.heappop(self.banners)\n        # Display top_banner for 1 hour\n        print(f"Displaying banner {top_banner[1].id} for 1 hour")\n        # Move top_banner to the end of the queue\n        heapq.heappush(self.banners, (top_banner[0], top_banner[1]))\n\n# Example usage\nsystem = BannerRotationSystem()\nbanners = [\n    Banner(1, 0.5),\n    Banner(2, 0.8),\n    Banner(3, 0.2),\n    Banner(4, 0.6)\n]\n\nfor banner in banners:\n    system.add_banner(banner)\n\nfor _ in range(4):\n    system.rotate_banners()