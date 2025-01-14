import numpy as np\n\ndef rank_products(feedbacks, iterations=100, d=0.85):\n    # Create adjacency matrix\n    products = sorted(set([item for feedback in feedbacks for item in feedback.keys()]))\n    num_products = len(products)\n    \n    product_index = {product: idx for idx, product in enumerate(products)}\n    \n    M = np.zeros((num_products, num_products))\n    \n    for feedback in feedbacks:\n        total_points = sum(feedback.values())\n        from_product = list(feedback.keys())[0]\n        for to_product, points in feedback.items():\n            if points > 0:\n                M[product_index[from_product]][product_index[to_product]] += points / total_points\n    \n    # Normalize columns\n    column_sums = np.sum(M, axis=0)\n    for i in range(num_products):\n        if column_sums[i] == 0:\n            continue\n        M[:, i] /= column_sums[i]\n    \n    # Initialize scores\n    scores = np.ones(num_products) / num_products\n    \n    # PageRank algorithm\n    for _ in range(iterations):\n        new_scores = (1 - d) + d * M.T @ scores\n        scores = new_scores\n    \n    product_ranks = {products[i]: scores[i] for i in range(num_products)}\n    \n    return dict(sorted(product_ranks.items(), key=lambda item: item[1], reverse=True))\n\n# Sample feedbacks\nfeedbacks = [\n    {'a': 150, 'b': 0},\n    {'a': 150, 'c': 20},\n    {'c': 200, 'a': 10},\n    {'a': 200, 'b': 40, 'c': 100},\n    {'a': 150, 'b': 50},\n    {'a': 150, 'b': 20}\n]\n\nranked_products = rank_products(feedbacks)\nprint(ranked_products)