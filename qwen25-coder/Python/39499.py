from sklearn.feature_extraction.text import TfidfVectorizer\nfrom sklearn.cluster import KMeans\n\n# Sample articles (in practice, Google News deals with millions of documents)\narticles = [\n    "Google launches new search algorithm",\n    "New algorithm optimizes Google's search results",\n    "Apple introduces iPhone 12 Pro",\n    "Tech innovation: New features in iPhone 12"\n]\n\n# Convert articles into TF-IDF vectors\nvectorizer = TfidfVectorizer(stop_words="english")\nX = vectorizer.fit_transform(articles)\n\n# Perform k-means clustering (here using 2 clusters as a simplification)\ntrue_k = 2\nmodel = KMeans(n_clusters=true_k, init='k-means++', max_iter=100, n_init=1)\nmodel.fit(X)\n\n# Show cluster assignments for articles\nprint("Top terms per cluster:")\norder_centroids = model.cluster_centers_.argsort()[:, ::-1]\nterms = vectorizer.get_feature_names_out()\nfor i in range(true_k):\n    print(f"Cluster {i}:")\n    for ind in order_centroids[i, :2]:  # top 2 words per cluster\n        print(f' {terms[ind]}')\n\nprint("\nArticle clusters:")\nfor label, article in zip(model.labels_, articles):\n    print(f"{label}: {article}")