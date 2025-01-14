SELECT \n    s.*,\n    UNIX_TIMESTAMP(s.`date`) AS `date`,\n    COUNT(f.ID) AS favorite_count,\n    CASE WHEN fu.ID IS NOT NULL THEN 1 ELSE 0 END AS is_favored_by_user\nFROM \n    songs s\nLEFT JOIN \n    (SELECT FAVORITE \n     FROM favorites \n     WHERE USERID = 'your_cookie_hash_here') fu ON s.ID = fu.FAVORITE\nLEFT JOIN \n    (SELECT FAVORITE, COUNT(ID) as count \n     FROM favorites \n     GROUP BY FAVORITE) fav_counts ON s.ID = fav_counts.FAVORITE\nWHERE \n    s.date >= DATE_SUB(NOW(), INTERVAL 2 WEEK)\nGROUP BY \n    s.ID\nORDER BY \n    s.`date` DESC;