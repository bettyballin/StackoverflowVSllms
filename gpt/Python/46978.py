import requests\nfrom requests_oauthlib import OAuth1\n\n# Replace with your app's credentials\nconsumer_key = 'your_consumer_key'\nconsumer_secret = 'your_consumer_secret'\naccess_token = 'user_access_token'\naccess_token_secret = 'user_access_token_secret'\n\nauth = OAuth1(consumer_key, consumer_secret, access_token, access_token_secret)\nurl = 'https://social.yahooapis.com/v1/user/me/contacts'\n\nresponse = requests.get(url, auth=auth)\ncontacts = response.json()\n\nfor contact in contacts['contacts']['contact']:\n    print(contact['fields'][0]['value'])