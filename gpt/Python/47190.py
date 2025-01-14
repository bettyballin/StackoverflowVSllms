import numpy as np\nfrom scipy.optimize import linear_sum_assignment\n\ndef calculate_distance_matrix(source_points, destination_points):\n    num_sources = len(source_points)\n    num_destinations = len(destination_points)\n    max_size = max(num_sources, num_destinations)\n\n    # Initialize the cost matrix with large values\n    cost_matrix = np.full((max_size, max_size), np.inf)\n\n    # Fill the cost matrix with actual distances\n    for i in range(num_sources):\n        for j in range(num_destinations):\n            cost_matrix[i][j] = np.linalg.norm(np.array(source_points[i]) - np.array(destination_points[j]))\n\n    return cost_matrix\n\ndef minimal_distance_assignment(source_points, destination_points):\n    cost_matrix = calculate_distance_matrix(source_points, destination_points)\n    \n    # Use the Hungarian algorithm to find the optimal assignment\n    row_ind, col_ind = linear_sum_assignment(cost_matrix)\n    \n    # Filter out the assignments that involve dummy points\n    assignments = [(source_points[i], destination_points[j]) for i, j in zip(row_ind, col_ind)\n                   if i < len(source_points) and j < len(destination_points)]\n    \n    total_distance = sum(cost_matrix[i, j] for i, j in zip(row_ind, col_ind)\n                         if i < len(source_points) and j < len(destination_points))\n    \n    return assignments, total_distance\n\n# Example usage\nsource_points = [(0, 0, 0), (1, 1, 1), (2, 2, 2)]\ndestination_points = [(1, 0, 0), (2, 1, 1)]\n\nassignments, total_distance = minimal_distance_assignment(source_points, destination_points)\nprint("Assignments:", assignments)\nprint("Total distance:", total_distance)