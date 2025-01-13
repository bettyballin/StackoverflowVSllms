while 'next_results' in data['search_metadata']:\n    next_results = data['search_metadata']['next_results']\n    next_url = search_url + next_results\n    response = requests.get(next_url, headers=headers)\n    data = response.json()\n    # Process the next set of tweets\n    total_tweets += len(data['statuses'])\n    # Calculate the number of pages again if needed\n    number_of_pages = total_tweets / tweets_per_page\n    print(f"Total Tweets: {total_tweets}")\n    print(f"Number of Pages: {number_of_pages}")