SELECT \n  c.*,\n  SUM(v.vote) AS total_votes,\n  v.vote AS user_vote\nFROM \n  comments c\n  LEFT JOIN votes v ON c.id = v.comment_id AND v.user_id = ?\nGROUP BY \n  c.id