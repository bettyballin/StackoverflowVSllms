$name = 'introduction';\n$mysqli = new mysqli('localhost', 'user', 'pass', 'db') or die('There was a problem connecting to the database.');\n$stmt = $mysqli->prepare("SELECT name, content FROM sections WHERE name = ?");\n$stmt->bind_param('s', $name);\n$stmt->execute();\n$stmt->bind_result($result_name, $content); // Bind both columns\n$stmt->fetch();\necho $content;\n$stmt->close();