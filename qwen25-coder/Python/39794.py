class KalmanFilter:\n    def __init__(self, initial_state=0, initial_variance=1, process_variance=1, measurement_variance=1):\n        self.state = initial_state\n        self.variance = initial_variance\n        self.process_variance = process_variance\n        self.measurement_variance = measurement_variance\n\n    def update(self, measurement):\n        # Prediction step (not changing state and variance in this simple model)\n        predicted_state = self.state\n        predicted_variance = self.variance + self.process_variance\n        \n        # Update step (adjusting state based on measurement)\n        kalman_gain = predicted_variance / (predicted_variance + self.measurement_variance)\n        self.state = predicted_state + kalman_gain * (measurement - predicted_state)\n        self.variance = (1 - kalman_gain) * predicted_variance\n        return self.state\n\n    def predict(self):\n        # For a more dynamic model, prediction steps could change state here.\n        return self.state