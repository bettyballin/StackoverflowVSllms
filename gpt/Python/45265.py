import re\n   import nltk\n   from nltk.corpus import stopwords\n   from nltk.tokenize import word_tokenize\n   from nltk.stem import WordNetLemmatizer\n\n   nltk.download('stopwords')\n   nltk.download('punkt')\n   nltk.download('wordnet')\n\n   def preprocess_text(text):\n       text = re.sub(r'http\S+', '', text)  # Remove URLs\n       text = re.sub(r'#\S+', '', text)     # Remove hashtags\n       text = re.sub(r'\W', ' ', text)      # Remove special characters\n       text = text.lower()                  # Convert to lowercase\n       tokens = word_tokenize(text)\n       tokens = [word for word in tokens if word not in stopwords.words('english')]\n       lemmatizer = WordNetLemmatizer()\n       tokens = [lemmatizer.lemmatize(word) for word in tokens]\n       return ' '.join(tokens)\n\n   # Example usage\n   sample_tweet = "Check out this link: https://example.com #example #twitter"\n   print(preprocess_text(sample_tweet))