import requests\nfrom requests_oauthlib import OAuth1\n\n# Replace these with your application's credentials and tokens\napi_key = 'YOUR_API_KEY'\napi_secret_key = 'YOUR_API_SECRET_KEY'\naccess_token = 'YOUR_ACCESS_TOKEN'\naccess_token_secret = 'YOUR_ACCESS_TOKEN_SECRET'\n\n# Twitter API endpoint for posting tweets\nurl = 'https://api.twitter.com/2/tweets'\n\n# OAuth1 authentication setup\nauth = OAuth1(api_key, api_secret_key, access_token, access_token_secret)\n\n# Data to be sent with the POST request\ndata = {'text': 'This tweet is posted from my application!'}\n\n# Sending the request\nresponse = requests.post(url, auth=auth, json=data)\n\nif response.status_code == 201:\n    print("Tweet posted successfully.")\nelse:\n    print("Failed to post tweet:", response.json())