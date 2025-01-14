from collections import Counter\n\n# Sample corpus\ncorpus = ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]\n\n# Calculate frequency\nword_counts = Counter(corpus)\ntotal_words = sum(word_counts.values())\n\n# Relative frequency\nrelative_freq = {word: count / total_words for word, count in word_counts.items()}