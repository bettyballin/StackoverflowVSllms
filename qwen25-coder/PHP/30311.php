$page = isset($_GET['page']) ? (int)$_GET['page'] : 1;\n$max = 5;\n\n// Calculate pagination limit\n$limit = ($page - 1) * $max;\n\n// First query to get the oldest post\n$oldestPostQuery = "SELECT * FROM posts ORDER BY date ASC LIMIT 1";\n\n// Second query to get the rest of the posts in descending order, excluding the oldest post\n$restPostsQuery = "SELECT * FROM posts WHERE id <> (SELECT id FROM posts ORDER BY date ASC LIMIT 1) ORDER BY date DESC LIMIT $limit, $max";\n\n// Union both queries\n$sql = "$oldestPostQuery UNION ALL ($restPostsQuery)";\n\n$result = mysql_query($sql);\n\n$totalres = mysql_result(mysql_query("SELECT COUNT(id) AS tot FROM posts"),0);\n$totalpages = ceil($totalres / $max);