SELECT SUM(CASE WHEN rating_type = 'up' THEN 1 WHEN rating_type = 'down' THEN -1 END CASE)\nFROM posts\nGROUP BY post_id