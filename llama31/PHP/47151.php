$mysqli = new mysqli('host', 'username', 'password', 'database');\n$query = 'SELECT * FROM (SELECT * FROM spy_hits ORDER BY date DESC) AS subquery GROUP BY ip LIMIT 10';\n$result = $mysqli->query($query);\nwhile ($row = $result->fetch_assoc()) {\n    // process the row\n}