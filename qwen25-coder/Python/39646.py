import numpy as np\n\ndef cauchy_matrix(x_values, y_values):\n    # Create a Cauchy matrix C where C[i,j] = 1 / (x_i + y_j)\n    X_size = len(x_values)\n    Y_size = len(y_values)\n    C = np.zeros((X_size, Y_size))\n    \n    for i in range(X_size):\n        for j in range(Y_size):\n            C[i][j] = 1.0 / (x_values[i] + y_values[j])\n    \n    return C\n\n# Example usage\nx_vector = [2, 3, 5]\ny_vector = [7, 11, 13, 17]\ncauchy_mat = cauchy_matrix(x_vector, y_vector)\nprint(cauchy_mat)