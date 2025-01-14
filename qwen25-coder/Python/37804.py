import requests\n\n# Example with Twitter\nclient_id = 'your_client_id'\nredirect_uri = 'https://your-website.com/callback'\n\nauthorization_url = "https://api.twitter.com/oauth/authorize"\nparams = {\n    'response_type': 'code',\n    'client_id': client_id,\n    'redirect_uri': redirect_uri,\n}\n\n# Redirect user to the authorization URL\nprint(f"Please go here and authorize: {authorization_url}?{requests.compat.urlencode(params)}")