import tweepy\nfrom apscheduler.schedulers.background import BackgroundScheduler\n\n# Replace these with your own credentials\nAPI_KEY = 'your_api_key'\nAPI_SECRET_KEY = 'your_api_secret_key'\nACCESS_TOKEN = 'user_access_token'\nACCESS_TOKEN_SECRET = 'user_access_token_secret'\n\ndef fetch_tweets():\n    auth = tweepy.OAuth1UserHandler(API_KEY, API_SECRET_KEY, ACCESS_TOKEN, ACCESS_TOKEN_SECRET)\n    api = tweepy.API(auth)\n\n    try:\n        tweets = api.user_timeline(count=10)  # Fetch the latest 10 tweets\n        for tweet in tweets:\n            print(tweet.text)\n    except tweepy.TweepError as e:\n        print(f"Error: {e}")\n\n# Schedule the job function to run every day at midnight\nscheduler = BackgroundScheduler()\nscheduler.add_job(fetch_tweets, 'cron', hour=0, minute=0)\nscheduler.start()\n\ntry:\n    # Keep the script running indefinitely\n    while True:\n        pass\nexcept (KeyboardInterrupt, SystemExit):\n    scheduler.shutdown()