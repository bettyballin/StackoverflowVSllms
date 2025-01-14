from requests_oauthlib import OAuth2Session\n\n# Example for Facebook - replace with actual credentials\nfacebook_client_id = 'YOUR_FACEBOOK_CLIENT_ID'\nfacebook_client_secret = 'YOUR_FACEBOOK_CLIENT_SECRET'\nfacebook_redirect_uri = 'https://your-redirect-uri.com'\n\nfacebook = OAuth2Session(facebook_client_id, redirect_uri=facebook_redirect_uri)\n\n# Redirect user to Facebook for authorization\nauthorization_url, state = facebook.authorization_url('https://www.facebook.com/dialog/oauth')\nprint('Please go here and authorize:', authorization_url)\n\n# Get the authorization verifier code from the callback url\nredirect_response = input('Paste the full redirect URL here: ')\ntokens = facebook.fetch_token('https://graph.facebook.com/oauth/access_token',\n                             authorization_response=redirect_response,\n                             client_secret=facebook_client_secret)\n\n# Make a request to Facebook's Graph API\nresponse = facebook.get('https://graph.facebook.com/me?fields=id,name,email')\nprint(response.content)