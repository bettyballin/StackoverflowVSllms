$query = mysql_query("\n  SELECT s.*, UNIX_TIMESTAMP(s.`date`) AS `date`, f.FAVORITE\n  FROM songs s\n  INNER JOIN favorites f ON s.ID = f.FAVORITE AND f.USERID = '$cookie_hash'\n  WHERE s.date >= DATE_SUB(NOW(), INTERVAL 2 WEEK)\n  ORDER BY s.date DESC\n");