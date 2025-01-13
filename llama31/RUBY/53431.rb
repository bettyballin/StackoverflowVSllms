require 'oauth'\n\nconsumer_key = 'your_consumer_key'\nconsumer_secret = 'your_consumer_secret'\ncallback_url = 'http://example.com/callback'\n\nconsumer = OAuth::Consumer.new(consumer_key, consumer_secret, {\n  site: 'https://twitter.com',\n  request_token_path: '/oauth/request_token',\n  authorize_path: '/oauth/authenticate',\n  access_token_path: '/oauth/access_token'\n})\n\nrequest_token = consumer.get_request_token(oauth_callback: callback_url)\nauthenticate_url = request_token.authorize_url\n\n# Redirect the user to the authenticate URL\nredirect_to authenticate_url