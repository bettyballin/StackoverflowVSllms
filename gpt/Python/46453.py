import numpy as np\nfrom sklearn.feature_extraction.text import TfidfVectorizer\nfrom sklearn.metrics.pairwise import cosine_similarity\n\n# Sample news articles\nnews_articles = [\n    "Saddam Hussein was the president of Iraq.",\n    "Donald Rumsfeld's business dealings in Iraq were controversial.",\n    "The economy is growing due to new policies.",\n    "The new tech startup is gaining popularity."\n]\n\n# Step 1: Text Preprocessing (simplified here)\n# Step 2: Feature Extraction using TF-IDF\nvectorizer = TfidfVectorizer(stop_words='english')\ntfidf_matrix = vectorizer.fit_transform(news_articles)\n\n# Step 3: Similarity Measurement using Cosine Similarity\ncosine_sim = cosine_similarity(tfidf_matrix, tfidf_matrix)\n\nprint("Cosine Similarity Matrix:")\nprint(cosine_sim)\n\n# Step 4: Using K-Nearest Neighbors to find related topics\nfrom sklearn.neighbors import NearestNeighbors\n\n# Fit the model\nknn = NearestNeighbors(n_neighbors=2, metric='cosine').fit(tfidf_matrix)\n\n# Find the nearest neighbors for the first article (index 0)\ndistances, indices = knn.kneighbors(tfidf_matrix[0], return_distance=True)\n\nprint("\nNearest neighbors for the first article:")\nfor index in indices.flatten():\n    print(news_articles[index])