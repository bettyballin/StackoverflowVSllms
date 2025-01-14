SELECT rev_id, sum(rev_rating)/count(rev_id) as avg_rating\nFROM reviews\nGROUP BY rev_id\nHAVING avg_rating > x;