import nltk\nfrom nltk.sentiment.vader import SentimentIntensityAnalyzer\n\n# Load the VADER sentiment analysis tool\nsia = SentimentIntensityAnalyzer()\n\n# Example text\ntext = "I'm so happy and excited for the weekend! 🎉"\n\n# Analyze the sentiment\nsentiment = sia.polarity_scores(text)\n\n# Determine the mood based on the sentiment score\nif sentiment['compound'] > 0.5:\n    mood = "Happy"\nelif sentiment['compound'] < -0.5:\n    mood = "Sad"\nelse:\n    mood = "Neutral"\n\nprint(mood)  # Output: Happy