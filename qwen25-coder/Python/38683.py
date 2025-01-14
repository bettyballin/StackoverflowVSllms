def warshalls_algorithm(graph):\n    n = len(graph)\n    transitive_closure = graph.copy()\n    \n    for k in range(n):\n        for i in range(n):\n            for j in range(n):\n                transitive_closure[i][j] = transitive_closure[i][j] or (transitive_closure[i][k] and transitive_closure[k][j])\n    \n    return transitive_closure\n\n# Example usage:\ngraph = [\n    [1, 0, 0],\n    [1, 1, 0],\n    [0, 1, 1]\n]\n\nprint(warshalls_algorithm(graph))