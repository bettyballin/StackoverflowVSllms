def transitive_reduction(adj_matrix):\n    n = len(adj_matrix)\n    \n    # Compute the transitive closure\n    closure = [[adj_matrix[i][j] for j in range(n)] for i in range(n)]\n    \n    for k in range(n):\n        for i in range(n):\n            for j in range(n):\n                closure[i][j] = closure[i][j] or (closure[i][k] and closure[k][j])\n    \n    # Remove transitive edges\n    reduced = [[adj_matrix[i][j] for j in range(n)] for i in range(n)]\n    \n    for i in range(n):\n        for j in range(n):\n            if i != j and adj_matrix[i][j]:\n                for k in range(n):\n                    if k != i and k != j and closure[i][k] and closure[k][j]:\n                        reduced[i][j] = 0\n                        break\n                        \n    return reduced\n\n# Example usage\nadj_matrix = [\n    [0, 1, 1, 1],\n    [0, 0, 0, 1],\n    [0, 0, 0, 1],\n    [0, 0, 0, 0]\n]\n\nreduced_matrix = transitive_reduction(adj_matrix)\nfor row in reduced_matrix:\n    print(row)