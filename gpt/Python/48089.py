from sklearn.cluster import DBSCAN\nimport numpy as np\nfrom geopy.geocoders import Nominatim\n\n# Example addresses list\naddresses = ["1600 Amphitheatre Parkway, Mountain View, CA",\n             "1 Infinite Loop, Cupertino, CA",\n             "345 Spear St, San Francisco, CA",\n             ...]\n\n# Function to get latitude and longitude from address\ndef get_lat_long(address):\n    geolocator = Nominatim(user_agent="geoapiExercises")\n    location = geolocator.geocode(address)\n    return (location.latitude, location.longitude)\n\n# Get latitude and longitude for all addresses\ncoordinates = np.array([get_lat_long(address) for address in addresses])\n\n# Configure DBSCAN\n# eps: maximum distance between two points to be considered as in the same neighborhood\n# min_samples: the minimum number of points to form a dense region (cluster)\ndb = DBSCAN(eps=0.1, min_samples=3, metric='haversine').fit(np.radians(coordinates))\n\n# Extract cluster labels\nlabels = db.labels_\n\n# Group addresses by cluster labels\nclusters = {}\nfor label, address in zip(labels, addresses):\n    if label not in clusters:\n        clusters[label] = []\n    clusters[label].append(address)\n\n# Display clustered addresses\nfor cluster, addresses in clusters.items():\n    print(f"Cluster {cluster}:")\n    for address in addresses:\n        print(f"  {address}")