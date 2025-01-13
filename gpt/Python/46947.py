from textblob import TextBlob\n\ndef analyze_sentiment(text):\n    analysis = TextBlob(text)\n    # Determine the polarity of the text\n    # Polarity is a float within the range [-1.0, 1.0]\n    sentiment_score = analysis.sentiment.polarity\n    \n    # Determine if sentiment is positive, negative, or neutral\n    if sentiment_score > 0:\n        sentiment = "Positive"\n    elif sentiment_score < 0:\n        sentiment = "Negative"\n    else:\n        sentiment = "Neutral"\n    \n    return sentiment, sentiment_score\n\n# Example usage\ntexts = [\n    "Jason is the worst SO user I have ever witnessed",\n    "Jason is an SO user",\n    "Jason is the best SO user I have ever seen",\n    "Jason is the best at sucking with SO",\n    "While, okay at SO, Jason is the worst at doing bad"\n]\n\nfor text in texts:\n    sentiment, score = analyze_sentiment(text)\n    print(f"Text: \"{text}\" \nSentiment: {sentiment}, Score: {score}\n")