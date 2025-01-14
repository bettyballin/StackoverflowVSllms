def topological_sort(adj_matrix):\n    from collections import deque\n    \n    n = len(adj_matrix)\n    in_degree = [0] * n\n    for i in range(n):\n        for j in range(n):\n            if adj_matrix[i][j]:\n                in_degree[j] += 1\n    \n    queue = deque([i for i in range(n) if in_degree[i] == 0])\n    topo_order = []\n    \n    while queue:\n        node = queue.popleft()\n        topo_order.append(node)\n        for j in range(n):\n            if adj_matrix[node][j]:\n                in_degree[j] -= 1\n                if in_degree[j] == 0:\n                    queue.append(j)\n    \n    return topo_order\n\n# Example usage\ntopo_order = topological_sort(reduced_matrix)\nprint("Topological Order:", topo_order)