import random\nimport numpy as np\n\ndef generate_matrices(ratio1, ratio2, size=4):\n    """\n    Generate two matrices with means in the ratio of ratio1:ratio2.\n    \n    Parameters:\n    - ratio1, ratio2: The desired ratio between the means of the two matrices.\n    - size: The number of elements in each matrix.\n    \n    Returns:\n    - Two lists (matrices) of numbers with the specified ratio between their means.\n    """\n    # Generate the first matrix with random 3-digit numbers\n    matrix1 = [random.randint(100, 999) for _ in range(size)]\n    \n    # Calculate the mean of the first matrix\n    mean1 = np.mean(matrix1)\n    \n    # Determine the target mean for the second matrix based on the ratio\n    target_mean2 = (ratio2 / ratio1) * mean1\n    \n    # Generate the second matrix by scaling random numbers to match the target mean\n    matrix2 = [int(target_mean2 * (random.random() * 2 - 1) + target_mean2) for _ in range(size)]\n    \n    # Ensure numbers in matrix2 are within the 3-digit range\n    matrix2 = [min(max(num, 100), 999) for num in matrix2]\n    \n    return matrix1, matrix2\n\n# Example usage\nratio1, ratio2 = 1, 2  # Define the ratio as 1:2\nmatrix1, matrix2 = generate_matrices(ratio1, ratio2)\n\nprint("Matrix 1:", matrix1)\nprint("Matrix 2:", matrix2)\n\n# Calculate and print the actual ratio of the means\nmean1 = np.mean(matrix1)\nmean2 = np.mean(matrix2)\nprint(f"Actual Ratio: {mean1}:{mean2}")