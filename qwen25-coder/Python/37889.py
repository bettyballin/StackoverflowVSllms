import numpy as np\nfrom scipy.optimize import linear_sum_assignment\n\ndef euclidean_distance(point1, point2):\n    return np.sqrt((point1[0] - point2[0])**2 + (point1[1] - point2[1])**2)\n\ndef find_optimal_mapping(points_A, points_B):\n    # Calculate the cost matrix\n    num_points = len(points_A)\n    cost_matrix = np.zeros((num_points, num_points))\n    \n    for i in range(num_points):\n        for j in range(num_points):\n            cost_matrix[i][j] = euclidean_distance(points_A[i], points_B[j])\n    \n    # Use the Hungarian algorithm to find the optimal assignment\n    row_ind, col_ind = linear_sum_assignment(cost_matrix)\n    \n    return list(zip(row_ind, col_ind)), cost_matrix[row_ind, col_ind].sum()\n\n# Example usage:\n# Points that are not overlapping\npoints_A = [(1, 1), (2, 3), (4, 5)]\npoints_B = [(5, 5), (6, 6), (7, 8)]\n\nmapping, total_distance = find_optimal_mapping(points_A, points_B)\nprint("Optimal mapping:", mapping)\nprint("Total distance:", total_distance)