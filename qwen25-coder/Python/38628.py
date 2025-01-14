# Example of basic anomaly detection using mean threshold\n   def detect_anomalies(data, thres_factor):\n       avg = sum(data) / len(data)\n       threshold = avg * thres_factor\n       return [x for x in data if x > threshold]