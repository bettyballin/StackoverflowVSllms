def a_star(start_node, goal_node):\n    open_list = [start_node]\n    closed_list = []\n    g_costs = {start_node: 0}\n    f_costs = {start_node: heuristic_cost_estimate(start_node, goal_node)}\n    \n    while open_list:\n        current = get_lowest_f_cost_node(open_list)\n        \n        if current == goal_node:\n            return reconstruct_path(came_from, current)\n        \n        open_list.remove(current)\n        closed_list.append(current)\n        \n        for neighbor in get_neighbors(current):\n            if neighbor in closed_list:\n                continue  # Ignore this neighbor\n\n            tentative_g = g_costs[current] + distance_between(current, neighbor)\n            \n            if neighbor not in open_list or tentative_g < g_costs[neighbor]:\n                came_from[neighbor] = current\n                g_costs[neighbor] = tentative_g\n                f_costs[neighbor] = tentative_g + heuristic_cost_estimate(neighbor, goal_node)\n                \n                if neighbor not in open_list:\n                    open_list.append(neighbor)\n    return None  # Fail to find a path