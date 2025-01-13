import nltk\nfrom nltk.corpus import wordnet\n\ndef semantic_distance(word1, word2):\n    synsets1 = wordnet.synsets(word1)\n    synsets2 = wordnet.synsets(word2)\n    \n    # Find the shortest path between synsets\n    min_distance = float('inf')\n    for syn1 in synsets1:\n        for syn2 in synsets2:\n            distance = syn1.shortest_path_distance(syn2)\n            if distance is not None and distance < min_distance:\n                min_distance = distance\n    \n    return min_distance\n\n# Example usage:\nword1 = "dog"\nword2 = "cat"\ndistance = semantic_distance(word1, word2)\nprint(f"Semantic distance between {word1} and {word2}: {distance}")