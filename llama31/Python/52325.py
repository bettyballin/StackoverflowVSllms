import numpy as np\nfrom scipy.spatial import KDTree\n\n# Define your slot values and data\nslots = np.array([0.0, 0.4, 0.6, 1.2, 5.0, 10.0])\ndata = np.array([0.1, 0.6, 4.23, 5.1, 7.0])\n\n# Create a k-d tree from the slot values\nkdtree = KDTree(slots[:, None])  # Note: we need to add a new axis to make it 2D\n\n# Query the k-d tree for each datum\nnearest_neighbors = kdtree.query(data[:, None])\n\n# Get the indices of the nearest neighbors (i.e., closest slot values)\nnearest_indices = nearest_neighbors[1]\n\n# Print the results\nfor i, datum in enumerate(data):\n    print(f" Datum {datum} is closest to slot {slots[nearest_indices[i]]}")