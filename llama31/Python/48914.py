import time\nfrom sklearn.linear_model import LinearRegression\nimport numpy as np\n\nclass DownloadTimePredictor:\n    def __init__(self):\n        self.start_time = None\n        self.percent_history = []\n        self.time_history = []\n\n    def start(self):\n        self.start_time = time.time()\n\n    def update(self, percent):\n        current_time = time.time()\n        self.percent_history.append(percent)\n        self.time_history.append(current_time - self.start_time)\n\n    def predict(self):\n        if len(self.percent_history) < 2:\n            return None\n\n        X = np.array(self.time_history).reshape(-1, 1)\n        y = np.array(self.percent_history)\n\n        model = LinearRegression()\n        model.fit(X, y)\n\n        predicted_time = (100 - y[-1]) / model.coef_[0]\n        return predicted_time\n\n# Example usage:\npredictor = DownloadTimePredictor()\npredictor.start()\n\nwhile True:\n    # Simulate download progress\n    time.sleep(1)\n    percent = min(100, predictor.time_history[-1] * 10 if predictor.time_history else 0)\n\n    predictor.update(percent)\n    predicted_time = predictor.predict()\n\n    if predicted_time is not None:\n        print(f"Predicted time remaining: {predicted_time:.2f} seconds")\n    else:\n        print("Not enough data to predict")\n\n    if percent == 100:\n        break