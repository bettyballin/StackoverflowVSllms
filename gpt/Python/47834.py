from scipy.optimize import linear_sum_assignment\nimport numpy as np\n\n# Example cost matrix\ncost_matrix = np.array([[4, 1, 3],\n                        [2, 0, 5],\n                        [3, 2, 2]])\n\n# Apply the Hungarian algorithm\nrow_ind, col_ind = linear_sum_assignment(cost_matrix)\n\n# Output the result\nprint("Optimal assignment:")\nfor r, c in zip(row_ind, col_ind):\n    print(f"Row {r} -> Column {c}")\n    \nprint("Minimum cost:", cost_matrix[row_ind, col_ind].sum())