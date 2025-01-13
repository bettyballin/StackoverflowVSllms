#Vectorization\nX = data['text']\ny = data['label']\n\ntrain_X, test_X, train_y, test_y = train_test_split(X, y, test_size = 0.25, random_state = 42)\n\nvectorizer = CountVectorizer(max_features = 10000, ngram_range = (1, 2))\ntrain_X_vectors = vectorizer.fit_transform(train_X)\n\ntransformer = TfidfTransformer()\ntrain_X_vectors_transformed = transformer.fit_transform(train_X_vectors)