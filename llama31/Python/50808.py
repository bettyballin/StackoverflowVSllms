import numpy as np\n\ndef euclidean_distance(set1, set2):\n    return np.sqrt(np.sum((np.array(set1) - np.array(set2)) ** 2))\n\ndef dtw_distance(set1, set2):\n    n = len(set1)\n    m = len(set2)\n    dtw = np.zeros((n + 1, m + 1))\n    dtw[0, 0] = 0\n    for i in range(1, n + 1):\n        dtw[i, 0] = float('inf')\n    for j in range(1, m + 1):\n        dtw[0, j] = float('inf')\n    for i in range(1, n + 1):\n        for j in range(1, m + 1):\n            cost = abs(set1[i - 1] - set2[j - 1])\n            dtw[i, j] = cost + min(dtw[i - 1, j], dtw[i, j - 1], dtw[i - 1, j - 1])\n    return dtw[n, m]