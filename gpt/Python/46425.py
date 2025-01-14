from sklearn.feature_extraction.text import TfidfVectorizer\nfrom sklearn.metrics.pairwise import cosine_similarity\nimport numpy as np\n\n# Sample summaries\nsummaries = [\n    "Building a new house in the city center.",\n    "Constructing a residential building downtown.",\n    "Designing and building a modern home.",\n    "Building a garage for the house.",\n    "Planning a new backyard swimming pool."\n]\n\n# Vectorize the summaries using TF-IDF\nvectorizer = TfidfVectorizer(stop_words='english')\ntfidf_matrix = vectorizer.fit_transform(summaries)\n\n# Compute cosine similarity matrix\ncosine_sim = cosine_similarity(tfidf_matrix)\n\n# Function to find similar summaries\ndef find_similar_summaries(index, threshold=0.5):\n    similar_indices = np.where(cosine_sim[index] > threshold)[0]\n    similar_indices = similar_indices[similar_indices != index]  # Exclude self-comparison\n    return similar_indices\n\n# Example: Find summaries similar to the first summary\nindex_to_check = 0\nsimilar_summaries = find_similar_summaries(index_to_check, threshold=0.3)\n\nprint(f"Summaries similar to '{summaries[index_to_check]}':")\nfor idx in similar_summaries:\n    print(f"- {summaries[idx]}")\n\n# Output:\n# Summaries similar to 'Building a new house in the city center.':\n# - Constructing a residential building downtown.\n# - Designing and building a modern home.