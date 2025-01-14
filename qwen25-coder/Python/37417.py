def topological_sort(graph):\n    visited = set()\n    stack = []\n\n    def dfs(node):\n        visited.add(node)\n        for neighbor in graph[node]:\n            if neighbor not in visited:\n                dfs(neighbor)\n        stack.append(node)\n\n    for node in graph:\n        if node not in visited:\n            dfs(node)\n\n    return stack[::-1]\n\n# Example usage:\ngraph = {\n    'A': ['B', 'C'],\n    'B': ['D'],\n    'C': ['D'],\n    'D': []\n}\n\nprint(topological_sort(graph))  # Output: ['D', 'B', 'C', 'A'] or any other valid order