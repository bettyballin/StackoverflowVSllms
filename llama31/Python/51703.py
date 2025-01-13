import nltk\nfrom nltk.corpus import stopwords\nfrom nltk.tokenize import word_tokenize\n\ndef similarity(phrase1, phrase2):\n    stop_words = set(stopwords.words('english'))\n    tokens1 = [word for word in word_tokenize(phrase1) if word not in stop_words]\n    tokens2 = [word for word in word_tokenize(phrase2) if word not in stop_words]\n    common_tokens = set(tokens1) & set(tokens2)\n    similarity = len(common_tokens) / max(len(tokens1), len(tokens2))\n    return similarity