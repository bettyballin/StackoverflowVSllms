$query = "INSERT IGNORE INTO andyasks (questions, date, user) VALUES ('" . mysql_real_escape_string($current['text']) . "','" . mysql_real_escape_string($current['created_at']) . "','Andy')";