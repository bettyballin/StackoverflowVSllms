import tweepy\n\nconsumer_key = "your_consumer_key"\nconsumer_secret = "your_consumer_secret"\naccess_token = "your_access_token"\naccess_token_secret = "your_access_token_secret"\n\nauth = tweepy.OAuthHandler(consumer_key, consumer_secret)\nauth.set_access_token(access_token, access_token_secret)\n\napi = tweepy.API(auth)\n\ntweets = api.search(q="cat", since="2022-01-01")\n\nfor tweet in tweets:\n    print(tweet.text)