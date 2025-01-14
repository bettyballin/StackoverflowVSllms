from sklearn.cluster import DBSCAN\nimport numpy as np\n\n# Sample data: points (latitude, longitude)\npoints = np.array([...])  # Insert your coordinates here as [[lat1, lon1], [lat2, lon2], ...]\n\ndef perform_clustering(points, eps=0.05):\n    """\n    Perform DBSCAN clustering on given points.\n    :param points: numpy array of shape (n_samples, n_features) where each row represents a point\n    :param eps: the maximum distance between two samples for them to be considered as in the same neighborhood\n    :return: labels: numpy array indicating cluster label for each sample (-1 indicates noise)\n    """\n    db = DBSCAN(eps=eps, min_samples=2).fit(points)\n    return db.labels_\n\n# Example usage\ncluster_labels = perform_clustering(points)\n\n# Now `cluster_labels` contains the cluster indices for each point.\n# Points with the same index are in the same cluster. -1 indicates an outlier (noise).