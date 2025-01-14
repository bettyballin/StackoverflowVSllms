import numpy as np\n\nclass PredictionMarket:\n    def __init__(self, initial_price):\n        self.initial_price = initial_price\n        self.current_price = initial_price\n        self.call_orders = []\n        self.put_orders = []\n        self.decay_factor = 0.95\n        self.price_change_limit = 0.1  # Max 10% change per update\n\n    def add_call_order(self, quantity, timestamp):\n        self.call_orders.append((quantity, timestamp))\n\n    def add_put_order(self, quantity, timestamp):\n        self.put_orders.append((quantity, timestamp))\n    \n    def calculate_weighted_average(self, orders):\n        if not orders:\n            return 0\n        total_quantity = sum(order[0] for order in orders)\n        weighted_sum = sum(order[0] * (self.decay_factor ** (order[1])) for order in orders)\n        return weighted_sum / total_quantity or 0\n\n    def update_price(self):\n        current_time = len(self.call_orders) + len(self.put_orders)  # Simplified timestamping\n                \n        call_ratio = self.calculate_weighted_average(self.call_orders)\n        put_ratio = self.calculate_weighted_average(self.put_orders)\n\n        if call_ratio > put_ratio:\n            price_adjustment = (call_ratio - put_ratio) * self.current_price\n        else:\n            price_adjustment = - (put_ratio - call_ratio) * self.current_price\n\n        # Limit the maximum price change per update\n        price_adjustment = np.clip(price_adjustment, -self.price_change_limit * self.current_price,\n                                   +self.price_change_limit * self.current_price)\n\n        self.current_price += price_adjustment\n        print(f"Updated Price: {self.current_price}")\n\n# Example usage:\nmarket = PredictionMarket(100)\nfor i in range(5):\n    market.add_call_order(np.random.randint(1, 10), i)\n    market.update_price()\n    \nfor j in range(5):\n    market.add_put_order(np.random.randint(1, 10), j + 5)\n    market.update_price()