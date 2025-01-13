from sklearn.feature_extraction.text import TfidfVectorizer\n\n   def tfidf_similarity(documents):\n       tfidf_vectorizer = TfidfVectorizer()\n       tfidf_matrix = tfidf_vectorizer.fit_transform(documents)\n       return (tfidf_matrix * tfidf_matrix.T).toarray()\n   \n   documents = ["Into the clear blue sky", "The color is sky blue", "In the blue clear sky"]\n   similarity_matrix = tfidf_similarity(documents)\n   print(similarity_matrix)