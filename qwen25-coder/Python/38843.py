from google.appengine.ext import db\n\nclass Link(db.Model):\n    user_hash = db.StringProperty()\n\ndef get_distinct_user_hashes_and_count():\n    # Fetch all user_hash from links\n    query = db.GqlQuery("SELECT user_hash FROM Link")\n    \n    # Use a set to store distinct user_hash values\n    distinct_user_hashes = {result.user_hash for result in query}\n    \n    # Count distinct user hashes\n    count_distinct = len(distinct_user_hashes)\n    \n    return distinct_user_hashes, count_distinct\n\n# Example usage\ndistinct_hashes, count = get_distinct_user_hashes_and_count()\nprint("Distinct User Hashes:", distinct_hashes)\nprint("Count of Distinct User Hashes:", count)