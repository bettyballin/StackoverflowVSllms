import numpy as np\nfrom scipy.spatial import KDTree\n\n# Define the color catalog as a numpy array\ncatalog = np.array([(r, g, b) for r, g, b in [...]])  # replace with your catalog data\n\n# Define the search color and threshold\nsearch_color = np.array([r, g, b])  # replace with the user-selected color\nthreshold = 10  # adjust this value to control the search radius\n\n# Create a k-d tree from the color catalog\ntree = KDTree(catalog)\n\n# Query the k-d tree for nearest neighbors within the threshold distance\ndistances, indices = tree.query(search_color, k=None, distance_upper_bound=threshold)\n\n# Get the indices of the matching images\nmatching_indices = indices[distances < threshold]\n\n# Retrieve the matching images from your database using the indices