import numpy as np\n\ndef get_qwerty_distance_matrix():\n    qwerty_layout = [\n        'qwertyuiop',\n        'asdfghjkl',\n        'zxcvbnm'\n    ]\n    keys = {key: (i, j) for i, row in enumerate(qwerty_layout) for j, key in enumerate(row)}\n    \n    max_distance = len(qwerty_layout) * len(max(qwerty_layout, key=len))\n    dist_matrix = np.zeros((256, 256), dtype=int)\n    for k1 in keys:\n        r1, c1 = keys[k1]\n        for k2 in keys:\n            if k1 == k2:\n                continue\n            r2, c2 = keys[k2]\n            dist_matrix[ord(k1)][ord(k2)] = abs(r1 - r2) + abs(c1 - c2)\n            dist_matrix[ord(k2)][ord(k1)] = abs(r2 - r1) + abs(c2 - c1)\n    return dist_matrix\n\ndef weighted_levenshtein(s1, s2):\n    if len(s1) < len(s2):\n        return weighted_levenshtein(s2, s1)\n    \n    # Initialize the matrix\n    dp = [list(range(i + 1)) for i in range(len(s1) + 1)]\n    \n    dist_matrix = get_qwerty_distance_matrix()\n    \n    for j in range(1, len(s2) + 1):\n        for i in range(1, len(s1) + 1):\n            if s1[i - 1] == s2[j - 1]:\n                cost = 0\n            else:\n                cost = dist_matrix[ord(s1[i - 1])][ord(s2[j - 1])]\n            \n            dp[i][j] = min(dp[i - 1][j] + 1,    # Deletion\n                           dp[i][j - 1] + 1,    # Insertion\n                           dp[i - 1][j - 1] + cost)  # Substitution\n    \n    return dp[len(s1)][len(s2)]\n\n# Example usage:\ns1 = "telephone"\ns2 = "yelephone"\ndistance = weighted_levenshtein(s1, s2)\nprint(f"Weighted Levenshtein distance between '{s1}' and '{s2}': {distance}")