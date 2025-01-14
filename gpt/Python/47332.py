def levenshtein_distance(s1, s2):\n    if len(s1) < len(s2):\n        return levenshtein_distance(s2, s1)\n\n    if len(s2) == 0:\n        return len(s1)\n\n    previous_row = range(len(s2) + 1)\n    for i, c1 in enumerate(s1):\n        current_row = [i + 1]\n        for j, c2 in enumerate(s2):\n            insertions = previous_row[j + 1] + 1\n            deletions = current_row[j] + 1\n            substitutions = previous_row[j] + (c1 != c2)\n            current_row.append(min(insertions, deletions, substitutions))\n        previous_row = current_row\n\n    return previous_row[-1]\n\ndef match_percentage(s1, s2):\n    distance = levenshtein_distance(s1, s2)\n    max_len = max(len(s1), len(s2))\n    percentage = (1 - distance / max_len) * 100\n    return percentage\n\n# Example usage:\ns1 = "kitten"\ns2 = "sitting"\nprint(f"Match percentage: {match_percentage(s1, s2):.2f}%")