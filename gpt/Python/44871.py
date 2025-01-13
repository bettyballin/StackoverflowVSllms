import tweepy\nimport schedule\nimport time\n\n# Set up your Twitter API credentials\nconsumer_key = 'YOUR_CONSUMER_KEY'\nconsumer_secret = 'YOUR_CONSUMER_SECRET'\naccess_token = 'USER_ACCESS_TOKEN'\naccess_token_secret = 'USER_ACCESS_TOKEN_SECRET'\n\n# Authenticate to Twitter\nauth = tweepy.OAuth1UserHandler(consumer_key, consumer_secret, access_token, access_token_secret)\napi = tweepy.API(auth)\n\ndef fetch_user_tweets():\n    try:\n        # Replace 'username' with the actual Twitter username\n        username = 'username'\n        tweets = api.user_timeline(screen_name=username, count=10)\n        for tweet in tweets:\n            print(f"{tweet.user.name} said {tweet.text}")\n    except tweepy.TweepError as e:\n        print(f"Error: {e}")\n\n# Schedule the job to run nightly\nschedule.every().day.at("00:00").do(fetch_user_tweets)\n\n# Keep the script running\nwhile True:\n    schedule.run_pending()\n    time.sleep(1)