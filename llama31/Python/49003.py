from sklearn.feature_extraction.text import TfidfVectorizer\nfrom sklearn.metrics.pairwise import cosine_similarity\nimport numpy as np\n\n# Sample questions\nquestions = [\n    "What is the best way to learn Python?",\n    "How do I improve my coding skills?",\n    "What are the most popular programming languages?"\n]\n\n# Create a TF-IDF vectorizer\nvectorizer = TfidfVectorizer(stop_words='english')\n\n# Fit the vectorizer to the questions and transform them into vectors\nvectors = vectorizer.fit_transform(questions)\n\n# Define a new question\nnew_question = "How can I learn to code?"\n\n# Transform the new question into a vector\nnew_vector = vectorizer.transform([new_question])\n\n# Calculate cosine similarity between the new question and existing questions\nsimilarities = cosine_similarity(new_vector, vectors).flatten()\n\n# Get the indices of the most similar questions\nsimilar_indices = np.argsort(-similarities)[:3]\n\n# Print the similar questions\nfor idx in similar_indices:\n    print(questions[idx])