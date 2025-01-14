from textblob import TextBlob\n\n# Sample inputs\ntexts = [\n    "The way on Iraq",\n    "Halloumni",\n    "BMW",\n    "Obama",\n    "Impala",\n    "The Berlin Wall",\n    "Bratwurst",\n    "Cheeseburger"\n]\n\n# Function to analyze topics\ndef extract_topics(text):\n    blob = TextBlob(text)\n    # Here we assume that noun phrases could be potential topics\n    return blob.noun_phrases\n\n# Analyze each input text\nfor text in texts:\n    topics = extract_topics(text)\n    print(f"Text: {text} -> Topics: {topics}")