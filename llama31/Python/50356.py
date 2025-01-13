import numpy as np\nfrom sklearn.feature_extraction.text import TfidfVectorizer\nfrom sklearn.model_selection import train_test_split\nfrom sklearn.naive_bayes import MultinomialNB\n\n# Example usage:\n# Load your labeled dataset\ntrain_data, test_data, train_labels, test_labels = train_test_split(data, labels, test_size=0.2)\n\nvectorizer = TfidfVectorizer()\nX_train = vectorizer.fit_transform(train_data)\ny_train = train_labels\n\nclf = MultinomialNB()\nclf.fit(X_train, y_train)\n\n# Use the trained model to classify new messages\nnew_message = "Some new message"\nnew_message_vector = vectorizer.transform([new_message])\nprediction = clf.predict(new_message_vector)\nif prediction == 0:  # adjust the labels\n    print("Nonsensical message detected!")