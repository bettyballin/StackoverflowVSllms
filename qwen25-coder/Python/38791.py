from sklearn.feature_extraction.text import TfidfVectorizer\nfrom sklearn.metrics.pairwise import cosine_similarity\n\n# Sample phrases\nphrases = [\n    "How do I compare phrases for similarity?",\n    "What algorithm can be used to find similar questions?",\n    "Methods for comparing text phrases",\n    "Search engine algorithms for similar content"\n]\n\n# Create TF-IDF vectors\nvectorizer = TfidfVectorizer(stop_words='english')\ntfidf_matrix = vectorizer.fit_transform(phrases)\n\n# Compute cosine similarity matrix\nsimilarity_matrix = cosine_similarity(tfidf_matrix, tfidf_matrix)\n\n# Display the similarity matrix\nprint(similarity_matrix)