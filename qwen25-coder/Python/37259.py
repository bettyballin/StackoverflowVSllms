import facebook\n\n# Initialize the Graph API with your access token\ngraph = facebook.GraphAPI(access_token='your_access_token_here')\n\n# Retrieve some data from the Graph API\nprofile = graph.get_object('me')\nprint(profile)