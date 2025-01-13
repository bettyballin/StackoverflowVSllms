import requests\n\n# Consumer key and secret from Feedly's Twitter OAuth settings\nconsumer_key = "your_consumer_key_here"\nconsumer_secret = "your_consumer_secret_here"\n\n# Redirect URI for OAuth callback\nredirect_uri = "http://www.feedly.com/twitter/oauth/callback"\n\n# Authorization URL for Twitter OAuth\nauth_url = "https://api.twitter.com/oauth/authorize"\n\n# Get request token\nresponse = requests.post(\n    "https://api.twitter.com/oauth/request_token",\n    headers={"Content-Type": "application/x-www-form-urlencoded"},\n    data={\n        "oauth_callback": redirect_uri,\n        "oauth_consumer_key": consumer_key,\n        "oauth_nonce": "your_nonce_here",\n        "oauth_signature_method": "HMAC-SHA1",\n        "oauth_timestamp": "your_timestamp_here",\n        "oauth_version": "1.0"\n    }\n)\n\n# Get authorization URL with request token\nrequest_token = response.json()["oauth_token"]\nauth_url_with_token = f"{auth_url}?oauth_token={request_token}"\n\n# User is redirected to authorization URL and grants access\n# After authorization, Twitter redirects back to redirect_uri with oauth_token and oauth_verifier\n\n# Get access token with request token and oauth_verifier\nresponse = requests.post(\n    "https://api.twitter.com/oauth/access_token",\n    headers={"Content-Type": "application/x-www-form-urlencoded"},\n    data={\n        "oauth_consumer_key": consumer_key,\n        "oauth_nonce": "your_nonce_here",\n        "oauth_signature_method": "HMAC-SHA1",\n        "oauth_timestamp": "your_timestamp_here",\n        "oauth_token": request_token,\n        "oauth_verifier": "your_oauth_verifier_here",\n        "oauth_version": "1.0"\n    }\n)\n\n# Get Twitter handle from access token response\naccess_token_response = response.json()\ntwitter_handle = access_token_response["screen_name"]