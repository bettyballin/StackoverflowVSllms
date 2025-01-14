import numpy as np\n\ndef z_score_normalization(data):\n    mean = np.mean(data, axis=0)\n    std = np.std(data, axis=0)\n    return (data - mean) / std\n\ndef euclidean_distance(set1, set2):\n    return np.sqrt(np.sum((set1 - set2) ** 2))\n\ndef find_most_similar(target_set, historical_sets):\n    target_set_normalized = z_score_normalization(target_set)\n    historical_sets_normalized = np.array([z_score_normalization(h) for h in historical_sets])\n    \n    distances = [euclidean_distance(target_set_normalized, h) for h in historical_sets_normalized]\n    sorted_indices = np.argsort(distances)\n    \n    return sorted_indices, np.array(distances)[sorted_indices]\n\n# Example usage\ntarget_set = np.array([20, 30, 40])\nhistorical_sets = [np.array([22, 33, 42]), np.array([18, 29, 39]), np.array([25, 35, 45])]\n\nsorted_indices, sorted_distances = find_most_similar(target_set, historical_sets)\nprint("Sorted indices of historical sets by similarity:", sorted_indices)\nprint("Corresponding distances:", sorted_distances)