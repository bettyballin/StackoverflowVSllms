import nltk\nfrom nltk.corpus import stopwords\nfrom nltk.tokenize import word_tokenize\nfrom nltk.stem import WordNetLemmatizer\nfrom collections import Counter\nimport re\n\n# Download necessary resources from NLTK\nnltk.download('punkt')\nnltk.download('stopwords')\nnltk.download('wordnet')\nnltk.download('omw-1.4')\n\ndef process_text(text):\n    # Remove non-alphabetic characters except hyphens within words\n    text = re.sub(r'[^\w\s-]', '', text)\n    \n    # Tokenize the text into words\n    tokens = word_tokenize(text.lower())\n    \n    # Define English stopwords to ignore, excluding proper nouns\n    stop_words = set(stopwords.words('english'))\n    \n    # Lemmatizer for stemming and plurals matching\n    lemmatizer = WordNetLemmatizer()\n    \n    # Filter out stop words and apply stemming\n    filtered_tokens = [lemmatizer.lemmatize(word) for word in tokens if word not in stop_words]\n    \n    return filtered_tokens\n\ndef get_word_frequencies(text):\n    processed_text = process_text(text)\n    # Count the frequency of each word\n    frequencies = Counter(processed_text)\n    return frequencies\n\n# Example usage\ntext = "The great service by Amazon was liked greatly. Their services are amazing."\nfrequencies = get_word_frequencies(text)\n\nprint(frequencies)