#Removing stopwords\nstop_words = set(stopwords.words('english'))\n\ndata['text'] = data['text'].apply(lambda x: " ".join(x for x in x.split() if x not in stop_words))