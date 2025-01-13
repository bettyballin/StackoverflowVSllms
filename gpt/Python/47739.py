import numpy as np\n\ndef weighted_random_without_replacement(elements, weights, k):\n    return np.random.choice(elements, size=k, replace=False, p=weights)\n\n# Example usage\nelements = ['a', 'b', 'c', 'd']\nweights = [0.1, 0.2, 0.3, 0.4]\nk = 3  # Number of selections\n\nresult = weighted_random_without_replacement(elements, weights, k)\nprint(result)