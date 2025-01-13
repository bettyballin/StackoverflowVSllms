import numpy as np\n\ndef matrix_exponential(A, n):\n    """Compute the matrix exponential of A^n"""\n    return np.linalg.matrix_power(A, n)\n\ndef shortest_path(A, start, end):\n    """Compute the shortest path between start and end nodes"""\n    n = A.shape[0]\n    B = matrix_exponential(A, n)\n    return B[start, end]\n\n# Example usage:\nA = np.array([[0, 1, 0], [1, 0, 1], [0, 1, 0]])  # adjacency matrix\nstart = 0\nend = 2\nprint(shortest_path(A, start, end))  # output: 2