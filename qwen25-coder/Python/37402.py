import numpy as np\n\n# Define the adjacency matrix for an undirected graph\nA = np.array([\n    [0, 1, 0, 1, 1],\n    [1, 0, 1, 0, 0],\n    [0, 1, 0, 0, 0],\n    [1, 0, 0, 0, 0],\n    [1, 0, 0, 0, 0]\n])\n\n# Calculate the degree matrix D\n# Diagonal entries are degrees of nodes (number of edges connected)\ndegrees = np.sum(A, axis=1)\nD = np.diag(degrees)\n\n# Calculate the Laplacian matrix L\nL = D - A\n\nprint("Degree Matrix:\n", D)\nprint("\nLaplacian Matrix:\n", L)