$user_id = intval($_COOKIE['user_id']);\n$query = mysql_query(sprintf("\n    SELECT *\n    FROM songs s\n       INNER JOIN favorites f\n       ON f.favorite = s.id\n    WHERE f.userid = %s\n", $user_id));