<?php\n// Get value coming from request\n$search = isset($_GET['search']) ? mysql_real_escape_string(trim($_GET['search'])) : '';\n\n// Connect to DB\n$conn = mysql_connect("localhost", "****", "****") or die(mysql_error());\nmysql_select_db("*****", $conn) or die(mysql_error());\n\n$result = mysql_query("SELECT title, type, username FROM dbArticle WHERE title LIKE '%$search%' OR type LIKE '%$search%' OR username LIKE '%$search%'", $conn);\n\n$suggestions = [];\nwhile ($row = mysql_fetch_array($result)) {\n    if (!empty($row['title'])) $suggestions[] = htmlspecialchars($row['title']);\n    if (!empty($row['type'])) $suggestions[] = htmlspecialchars($row['type']);\n    if (!empty($row['username'])) $suggestions[] = htmlspecialchars($row['username']);\n}\n\n// Echo JSON response\nheader('Content-Type: application/json');\necho json_encode(array_unique($suggestions));\n\nmysql_close();\n?>