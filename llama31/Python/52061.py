import numpy as np\nfrom sklearn.decomposition import TruncatedSVD\n\ndef lsa_similarity(articles):\n    vectorizer = TfidfVectorizer()\n    tfidf_matrix = vectorizer.fit_transform(articles)\n    svd = TruncatedSVD(n_components=100)\n    lsa_matrix = svd.fit_transform(tfidf_matrix)\n    return lsa_matrix.dot(lsa_matrix.T)