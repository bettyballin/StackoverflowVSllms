import random\n\ndef get_crossover_points(tree, max_depth):\n    """Get all possible crossover points within a certain depth."""\n    points = []\n\n    def recurse(node, depth):\n        if isinstance(node, list) and depth < max_depth:\n            points.append((node, node[0]))\n            for i in range(1, len(node)):\n                if isinstance(node[i], list):\n                    recurse(node[i], depth + 1)\n\n    recurse(tree, 1)\n    return points\n\ndef crossover(tree1, tree2, max_depth):\n    """Perform crossover between two trees."""\n    points1 = get_crossover_points(tree1, max_depth)\n    points2 = get_crossover_points(tree2, max_depth)\n\n    if not points1 or not points2:\n        return None, None  # No valid crossover points found\n\n    point1_index = random.randint(0, len(points1) - 1)\n    _, sub_tree_1 = points1[point1_index]\n\n    possible_points_in_tree2 = [point for point in points2 if point[1] == sub_tree_1]\n    if not possible_points_in_tree2:\n        return None, None\n\n    point2_index = random.randint(0, len(possible_points_in_tree2) - 1)\n    parent_node_2, _ = possible_points_in_tree2[point2_index]\n    \n    # Copy trees to avoid modifying originals\n    tree_child1, tree_child2 = [tree.copy() for tree in (tree1, tree2)]\n    index2 = parent_node_2.index(points2[point2_index][0])\n    \n    # Swap subtrees\n    tree_child1[points1[point1_index][0]] = points2[point2_index][0]\n    tree_child2[index2] = points1[point1_index][0]\n\n    return tree_child1, tree_child2\n\n# Example usage:\nmax_depth_limit = 3\ntree1 = ['f:2', ['f:3', 'a', 'a', 'a'], 'a']\ntree2 = ['f:2', ['f:2', 'a', 'a'], ['f:1', 'a']]\n\ntree_child1, tree_child2 = crossover(tree1, tree2, max_depth_limit)\n\nprint("Tree Child 1:", tree_child1)\nprint("Tree Child 2:", tree_child2)