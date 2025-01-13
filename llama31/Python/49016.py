import numpy as np\n\n# Original 1D image with 6 points\noriginal_data = np.array([1, 2, 3, 4, 5, 6])\n\n# Downscale to 3 points using averaging\ndownscaled_data = np.mean(original_data.reshape(-1, 2), axis=1)\n\nprint(downscaled_data)  # Output: [1.5, 3.5, 5.5]