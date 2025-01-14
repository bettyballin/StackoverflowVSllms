import heapq\n\ndef heuristic(time_at_node, target_time):\n    # Simple heuristic based on the difference in time.\n    return abs(target_time - time_at_node)\n\ndef find_route(start_time, start_stop_id, target_stop_id, schedule):\n    # Priority queue to hold (total estimated travel time, current node, path)\n    priority_queue = []\n    # Dictionary to store minimum cost to reach a node\n    min_cost = {}\n    \n    # Push the initial state: (travel_time + heuristic, current_node, path_to_here)\n    heapq.heappush(priority_queue, (0 + heuristic(start_time, start_time), (start_time, start_stop_id), [(start_time, start_stop_id)]))\n    \n    while priority_queue:\n        total_estimated_travel_time, (current_time, current_stop_id), path = heapq.heappop(priority_queue)\n        \n        # If we've reached our goal, return the path\n        if current_stop_id == target_stop_id:\n            return path\n        \n        # Don't process this node again if we've found a better one already\n        if current_time in min_cost and total_estimated_travel_time > min_cost[current_time]:\n            continue\n        \n        # For every possible action (wait at stop, walk to another stop)\n        for next_node, travel_time in schedule.get_transitions_from(current_stop_id, current_time):\n            new_time = current_time + travel_time\n            cost_to_next_node = total_estimated_travel_time - heuristic(current_time, start_time) + travel_time\n            \n            if new_time not in min_cost or cost_to_next_node < min_cost[new_time]:\n                min_cost[new_time] = cost_to_next_node\n                heapq.heappush(priority_queue,\n                                 (cost_to_next_node + heuristic(new_time, start_time), \n                                  (new_time, next_node),\n                                  path + [(new_time, next_node)]))\n    \n    return None  # No route found\n\n# Example schedule.get_transitions_from function (pseudo-code)\ndef get_transitions_from(stop_id, current_time):\n    # Logic to find all possible next stops from stop_id at current_time\n    yield next_stop_id, travel_or_wait_time