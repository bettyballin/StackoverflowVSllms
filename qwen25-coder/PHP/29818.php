<?php\n// Assuming proper validation and sanitization of $_GET['id']\n$id = intval($_GET['id']);\n\n$query = mysql_query("SELECT news.*, users.username \n                     FROM news \n                     INNER JOIN users ON news.user_id = users.id \n                     WHERE news.id = $id");\n\nif ($query) {\n    $news = mysql_fetch_assoc($query);\n    echo "News Title: " . htmlspecialchars($news['title']) . "<br>";\n    echo "Author: " . htmlspecialchars($news['username']);\n} else {\n    exit(mysql_error());\n}\n?>