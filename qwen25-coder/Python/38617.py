from sklearn.cluster import DBSCAN\nimport numpy as np\n\n# Sample data: list of (latitude, longitude) tuples\ncoordinates = [\n    (40.7128, -74.0060),  # New York City\n    (34.0522, -118.2437), # Los Angeles\n    (41.8781, -87.6298),  # Chicago\n    (37.7749, -122.4194), # San Francisco\n    # Add more coordinates as needed...\n]\n\n# Convert to a numpy array\ncoords_array = np.array(coordinates)\n\n# DBSCAN clustering\ndbscan = DBSCAN(eps=0.5, min_samples=3, algorithm='ball_tree', metric='haversine').fit(np.radians(coords_array))\nlabels = dbscan.labels_\n\n# Output the cluster labels for each point\nprint(labels)