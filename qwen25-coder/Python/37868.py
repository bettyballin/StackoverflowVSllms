import joblib\nimport sys\n\ndef predict_category(text):\n    vectorizer, classifier = joblib.load('model.pkl')\n    X_test = vectorizer.transform([text])\n    return classifier.predict(X_test)[0]\n\n# Example usage from command line\nif __name__ == "__main__":\n    text = sys.argv[1]\n    category = predict_category(text)\n    print(category)