from collections import defaultdict\n\n# Sample sentences\nsentences = [\n    "The beautiful sky.",\n    "Beautiful sky dream.",\n    "Beautiful dream."\n]\n\n# Index structure\ninverted_index = defaultdict(lambda: {'positions': [], 'related_words': set()})\n\ndef preprocess(text):\n    return text.strip().lower().split()\n\nfor sentence_id, sentence in enumerate(sentences):\n    words = preprocess(sentence)\n    for pos, word in enumerate(words):\n        inverted_index[word]['positions'].append((sentence_id, pos))\n        if pos > 0:\n            inverted_index[word]['related_words'].add(words[pos - 1])\n        if pos < len(words) - 1:\n            inverted_index[word]['related_words'].add(words[pos + 1])\n\n# Function to search\ndef search(word):\n    word = word.strip().lower()\n    if word in inverted_index:\n        positions = inverted_index[word]['positions']\n        related_words = inverted_index[word]['related_words']\n        return f"Word: {word}\nPositions: {positions}\nRelated Words: {related_words}"\n    else:\n        return f"Word '{word}' not found."\n\n# Example search\nprint(search('beautiful'))