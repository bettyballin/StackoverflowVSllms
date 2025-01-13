import numpy as np\n\ndef pagerank(graph, damping_factor=0.85, max_iterations=100):\n    num_pages = len(graph)\n    pagerank_values = np.ones(num_pages) / num_pages\n\n    for _ in range(max_iterations):\n        new_pagerank_values = np.zeros(num_pages)\n        for i in range(num_pages):\n            for j in range(num_pages):\n                if graph[j][i] == 1:  # if there's a link from j to i\n                    new_pagerank_values[i] += pagerank_values[j] * damping_factor\n        pagerank_values = new_pagerank_values\n\n    return pagerank_values\n\n# Example graph represented as an adjacency matrix\ngraph = np.array([\n    [0, 1, 0, 0],\n    [1, 0, 1, 0],\n    [0, 1, 0, 1],\n    [0, 0, 1, 0]\n])\n\npagerank_values = pagerank(graph)\nprint(pagerank_values)