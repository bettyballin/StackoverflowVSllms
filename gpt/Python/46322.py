from sklearn.cluster import DBSCAN\nimport numpy as np\n\n# Example data: list of (latitude, longitude) tuples\ncoordinates = [\n    (37.7749, -122.4194),\n    (34.0522, -118.2437),\n    (40.7128, -74.0060),\n    # Add more coordinates as needed\n]\n\n# Convert to numpy array\ncoords = np.array(coordinates)\n\n# Haversine distance requires radians\ncoords_radians = np.radians(coords)\n\n# DBSCAN parameters\nepsilon = 0.1  # Maximum distance between points to be considered in the same cluster\nmin_samples = 2  # Minimum number of points to form a cluster\n\n# Define and fit DBSCAN\ndb = DBSCAN(eps=epsilon, min_samples=min_samples, metric='haversine').fit(coords_radians)\n\n# Get cluster labels\nlabels = db.labels_\n\n# Print cluster labels (-1 indicates noise)\nprint(labels)