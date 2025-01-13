def levenshtein_distance(s1, s2):\n    if len(s1) > len(s2):\n        s1, s2 = s2, s1\n\n    distances = range(len(s1) + 1)\n    for i2, c2 in enumerate(s2):\n        distances_ = [i2+1]\n        for i1, c1 in enumerate(s1):\n            if c1 == c2:\n                distances_.append(distances[i1])\n            else:\n                distances_.append(1 + min((distances[i1], distances[i1 + 1], distances_[-1])))\n        distances = distances_\n    return distances[-1]\n\n# Example usage:\ntext1 = "Name 1, Comment"\ntext2 = "Name 2, Comment"\ntext3 = "Name 3 , Comment"  # Note the extra space\n\nprint(levenshtein_distance(text1, text2))  # Output: 1\nprint(levenshtein_distance(text1, text3))  # Output: 2