ORDER BY \n  CASE WHEN user_id = ? THEN 0 ELSE 1 END,\n  rating DESC,\n  title