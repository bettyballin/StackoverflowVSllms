user = db.GqlQuery("SELECT user_hash FROM links")\nuser_counts = {}\nfor u in user:\n    user_counts[u.user_hash] = user_counts.get(u.user_hash, 0) + 1\ndistinct_users = user_counts.keys()\ncount = len(distinct_users)