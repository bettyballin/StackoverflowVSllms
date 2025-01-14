def find_paths_through_nodes(nodes_set, dag):\n    def dfs(current_node, visited, path):\n        if set(path) == nodes_set:\n            return [path]\n        paths = []\n        for neighbor in dag[current_node]:\n            if neighbor not in visited:\n                new_path = path + [neighbor]\n                visited.add(neighbor)\n                if len(set(new_path) & nodes_set) > len(set(path) & nodes_set):\n                    paths += dfs(neighbor, visited, new_path)\n                visited.remove(neighbor)\n        return paths\n\n    all_paths = []\n    for node in dag:\n        all_paths.extend(dfs(node, set([node]), [node]))\n\n    return all_paths