from collections import defaultdict\n\nclass Graph:\n    def __init__(self):\n        self.graph = defaultdict(list)\n\n    def add_edge(self, u, v):\n        self.graph[u].append(v)\n\n    def is_cyclic_util(self, v, visited, rec_stack):\n        visited[v] = True\n        rec_stack[v] = True\n\n        for neighbor in self.graph[v]:\n            if not visited[neighbor]:\n                if self.is_cyclic_util(neighbor, visited, rec_stack):\n                    return True\n            elif rec_stack[neighbor]:\n                return True\n\n        rec_stack[v] = False\n        return False\n\n    def is_cyclic(self):\n        visited = {key: False for key in self.graph}\n        rec_stack = {key: False for key in self.graph}\n\n        for node in self.graph:\n            if not visited[node]:\n                if self.is_cyclic_util(node, visited, rec_stack):\n                    return True\n        return False\n\n    def add_edge_and_check(self, u, v):\n        self.add_edge(u, v)\n        if self.is_cyclic():\n            print(f"Adding edge {u} -> {v} creates a cycle. Reverting.")\n            self.graph[u].remove(v)\n        else:\n            print(f"Edge {u} -> {v} added successfully.")\n\n# Example usage:\ng = Graph()\ng.add_edge_and_check(0, 1)\ng.add_edge_and_check(1, 2)\ng.add_edge_and_check(2, 3)\ng.add_edge_and_check(3, 0)  # This should revert as it creates a cycle