from sklearn.cluster import DBSCAN\nimport numpy as np\nimport matplotlib.pyplot as plt\n\n# Sample data: list of (x, y) coordinates of dots\ndots = np.array([\n    [1.0, 2.0], [1.5, 1.8], [5.0, 8.0], [8.0, 8.0],\n    [1.0, 0.6], [9.0, 11.0], [8.0, 2.0], [10.0, 2.0],\n    [9.0, 3.0]\n])\n\n# Create DBSCAN model\ndb = DBSCAN(eps=2, min_samples=2)\n\n# Fit model and predict clusters\nclusters = db.fit_predict(dots)\n\n# Plot the results\nplt.scatter(dots[:, 0], dots[:, 1], c=clusters, cmap='viridis')\nplt.title('DBSCAN Clustering')\nplt.xlabel('X Coordinate')\nplt.ylabel('Y Coordinate')\nplt.show()