import numpy as np\nfrom scipy.spatial import cKDTree\n\n# Example dataset of points (replace with your actual point data)\npoints = np.random.rand(1000000, 2)  # 1 million points in 2D space\n\n# Construct the KD-Tree\ntree = cKDTree(points)\n\n# Query point (the location you want to find nearby points to)\nquery_point = np.array([0.5, 0.5])\n\n# Perform the query for the nearest 1000 points\n# Adjust the 'k' parameter to control the number of nearest points to return.\ndistances, indices = tree.query(query_point, k=1000)\n\n# Retrieve the nearest points\nnearest_points = points[indices]\n\n# Example of output\nprint("Nearest points:", nearest_points)