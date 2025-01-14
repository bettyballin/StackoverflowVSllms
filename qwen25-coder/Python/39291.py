import networkx as nx\n\n# Assuming 'edges' is a list of tuples representing the connections between users\n# Example: edges = [(user_id1, user_id2), (user_id3, user_id4), ...]\nedges = [...]  # Load your 20 million connections here\n\n# Create a graph object\nG = nx.Graph()\n\n# Add all edges to the graph\nG.add_edges_from(edges)\n\ndef six_degrees_of_separation(G):\n    total_paths = 0\n    longest_path_length = 0\n    unreachable_nodes = 0\n    \n    for node in G.nodes():\n        try:\n            # Calculate shortest paths from this node to all reachable nodes\n            shortest_paths = nx.shortest_path_length(G, source=node)\n            \n            # Update statistics\n            total_paths += sum(shortest_paths.values())\n            longest_node_path = max(shortest_paths.values())\n                \n            if longest_node_path > longest_path_length:\n                longest_path_length = longest_node_path\n                \n        except nx.NetworkXError:\n            # This occurs when the node cannot reach any other nodes (isolated or not connected)\n            unreachable_nodes += 1\n            continue\n    \n    average_shortest_path_length = total_paths / len(G.nodes())\n    \n    print(f"Average shortest path length: {average_shortest_path_length}")\n    print(f"Longest shortest path found: {longest_path_length}")\n    print(f"Number of nodes with no connection to any other node: {unreachable_nodes}")\n\n# Run the analysis\nsix_degrees_of_separation(G)