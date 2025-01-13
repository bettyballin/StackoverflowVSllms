import tweepy\n\n# assuming you have the access token stored securely\naccess_token = "your_access_token_here"\naccess_token_secret = "your_access_token_secret_here"\n\nauth = tweepy.OAuthHandler(consumer_key, consumer_secret)\nauth.set_access_token(access_token, access_token_secret)\n\napi = tweepy.API(auth)\n\n# retrieve the user's tweets\ntweets = api.user_timeline(screen_name="username", count=100)\n\n# process the tweets\nfor tweet in tweets:\n    print(tweet.text)