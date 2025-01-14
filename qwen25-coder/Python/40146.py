def levenshtein_distance(s1, s2):\n    if len(s1) < len(s2):\n        return levenshtein_distance(s2, s1)\n\n    # If one of the strings is empty\n    if len(s2) == 0:\n        return len(s1)\n\n    # Initialize previous row of distances\n    previous_row = range(len(s2) + 1)\n    for i, c1 in enumerate(s1):\n        current_row = [i + 1]\n        for j, c2 in enumerate(s2):\n            insertions = previous_row[j + 1] + 1       # Insertion\n            deletions = current_row[j] + 1          # Deletion\n            substitutions = previous_row[j] + (c1 != c2)  # Substitution\n            current_row.append(min(insertions, deletions, substitutions))\n        previous_row = current_row\n\n    return previous_row[-1]\n\n# Example usage:\ndistance1 = levenshtein_distance("Acme Company", "Acme Comapny")  # Small distance\ndistance2 = levenshtein_distance("Acme Company", "Cmea Mpnyaco")    # Large distance\ndistance3 = levenshtein_distance("Acme Company", "Acme Comp.")     # Small distance\ndistance4 = levenshtein_distance("Acme Company", "Company Acme")   # Requires handling order\n\nprint(distance1, distance2, distance3)