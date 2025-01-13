// Example of using Python and Scikit-learn for anomaly detection\n   from sklearn.ensemble import IsolationForest\n   import numpy as np\n   \n   # Sample data: user request times\n   data = np.array([[1], [2], [2], [3], [4], [100], [101], [102]])\n   \n   # Training the model\n   model = IsolationForest(contamination=0.1)\n   model.fit(data)\n   \n   # Predicting anomalies\n   predictions = model.predict(data)\n   print(predictions)  # -1 for anomalies, 1 for normal