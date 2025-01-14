import numpy as np\n\n# Create a 3D array (2x3x4)\narray_3d = np.random.rand(2, 3, 4)\n\n# Using slicing with ellipsis\n# Select the first and last element along the first dimension,\n# all elements along any middle dimensions,\n# and the second element along the last dimension.\nresult = array_3d[[0, -1], ..., 1]