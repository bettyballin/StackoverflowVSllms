from nltk.tokenize import word_tokenize\nfrom nltk.corpus import stopwords\nfrom nltk.stem import PorterStemmer\nfrom scipy.spatial.distance import cosine\n\ndef calculate_similarity(text1, text2):\n    # Tokenize the text and remove stop words\n    tokens1 = [t for t in word_tokenize(text1) if t not in stopwords.words('english')]\n    tokens2 = [t for t in word_tokenize(text2) if t not in stopwords.words('english')]\n\n    # Stem the tokens\n    stemmer = PorterStemmer()\n    tokens1 = [stemmer.stem(t) for t in tokens1]\n    tokens2 = [stemmer.stem(t) for t in tokens2]\n\n    # Calculate the vector representations of the text\n    vector1 = [t in tokens1 for t in set(tokens1 + tokens2)]\n    vector2 = [t in tokens2 for t in set(tokens1 + tokens2)]\n\n    # Calculate the Cosine similarity\n    similarity = 1 - cosine(vector1, vector2)\n\n    return similarity\n\n# Example usage\ntext1 = "This is a test page with some content."\ntext2 = "This page has the same content, but with a different timestamp."\nsimilarity = calculate_similarity(text1, text2)\nprint(similarity)