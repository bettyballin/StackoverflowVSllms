SELECT COUNT(DISTINCT CASE WHEN userid > 0 THEN userid ELSE IP END) AS unique_users_count,\n       COUNT(DISTINCT CASE WHEN userid > 0 THEN userid END) AS registered_users_count\nFROM `bigBrother`\nWHERE datetime BETWEEN DATE_SUB(NOW(), INTERVAL 3 MINUTE) AND NOW();