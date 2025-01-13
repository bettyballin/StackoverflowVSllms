def detect_cycle(graph):\n    visited = set()\n    stack = set()\n\n    def visit(node):\n        if node in stack:\n            return True\n        if node in visited:\n            return False\n        stack.add(node)\n        for neighbor in graph[node]:\n            if visit(neighbor):\n                return True\n        stack.remove(node)\n        visited.add(node)\n        return False\n\n    for node in graph:\n        if visit(node):\n            return True\n    return False\n\n# Example usage:\ngraph = {\n    'A': ['B'],\n    'B': ['C'],\n    'C': ['A'],  # This introduces a cycle\n    'D': ['E'],\n    'E': []\n}\n\nprint(detect_cycle(graph))  # Output: True