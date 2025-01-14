import numpy as np\nfrom scipy.optimize import linear_sum_assignment\n\ndef getMaxCTR(companies, people, ctrPairs):\n    # Create a cost matrix where the value is the negative of the pair value\n    n = len(companies)\n    cost_matrix = np.zeros((n, n))\n    \n    for i, c in enumerate(companies):\n        for j, p in enumerate(people):\n            cost_matrix[i][j] = -ctrPairs[(c, p)]  # Use negative because we want to maximize the sum\n    \n    # Solve the assignment problem\n    row_ind, col_ind = linear_sum_assignment(cost_matrix)\n    \n    # Calculate the maximumCTR by summing up the pair values of the optimal assignment\n    maxCTR = sum(ctrPairs[companies[i], people[j]] for i in row_ind for j in col_ind if j == col_ind[row_ind.index(i)])\n    \n    return maxCTR\n\n# Example usage:\ncompanies = ['C1', 'C2', 'C3']\npeople = ['P1', 'P2', 'P3']\nctrPairs = {\n    ('C1', 'P1'): 10, ('C1', 'P2'): 8, ('C1', 'P3'): 7,\n    ('C2', 'P1'): 6, ('C2', 'P2'): 9, ('C2', 'P3'): 4,\n    ('C3', 'P1'): 5, ('C3', 'P2'): 8, ('C3', 'P3'): 10\n}\n\nprint(getMaxCTR(companies, people, ctrPairs))