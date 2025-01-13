from sklearn.metrics.pairwise import cosine_similarity\nfrom sklearn.feature_extraction.text import CountVectorizer\n\ndef cosine_similarity_distance(s1, s2):\n    vectorizer = CountVectorizer().fit([s1, s2])\n    vectors = vectorizer.transform([s1, s2])\n    return cosine_similarity(vectors[0:1], vectors[1:2]).ravel()[0]