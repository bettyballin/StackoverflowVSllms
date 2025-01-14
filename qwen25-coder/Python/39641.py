import feedparser\n\ndef get_feed_entries(feed_url):\n    feed = feedparser.parse(feed_url)\n    return feed.entries\n\ndef check_for_new_posts(feed_url, last_known_id_set):\n    current_entries = get_feed_entries(feed_url)\n    new_posts = [entry for entry in current_entries if entry.id not in last_known_id_set]\n    \n    # Update the set of known IDs with newly fetched ones\n    last_known_id_set.update([entry.id for entry in new_entries])\n    \n    return new_posts\n\n# Example usage\nfeed_url = 'https://example.com/rss'\nlast_known_ids = set()  # This should persist between checks, e.g., in a database\n\nnew_posts = check_for_new_posts(feed_url, last_known_ids)\n\nfor post in new_posts:\n    print(f"New Post: {post.title}")