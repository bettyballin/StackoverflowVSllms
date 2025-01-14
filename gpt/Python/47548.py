def calculate_distance(word1, word2):\n    assert len(word1.replace(" ", "")) == len(word2.replace(" ", ""))\n    word1_parts = word1.split()\n    word2_parts = word2.split()\n    \n    i = j = distance = 0\n    while i < len(word1_parts) and j < len(word2_parts):\n        if word1_parts[i] == word2_parts[j]:\n            i += 1\n            j += 1\n        else:\n            distance += 1\n            if len(word1_parts[i]) < len(word2_parts[j]):\n                i += 1\n            else:\n                j += 1\n    distance += abs(len(word1_parts) - len(word2_parts))\n    return distance\n\n# Example usage\nword1 = "a ids"\nword2 = "ai d s"\nprint(calculate_distance(word1, word2))