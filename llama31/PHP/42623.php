<?php\n// Assuming you have a $xmlContent variable containing your XML\n$xml = simplexml_load_string($xmlContent);\n$text = (string)$xml->path->to->node;\n\n// Connect to the database, ensuring UTF-8 charset\n$mysqli = new mysqli("localhost", "my_user", "my_password", "my_database");\n$mysqli->set_charset("utf8mb4");\n\n// Insert into the database\n$mysqli->query("INSERT INTO table (column) VALUES ('$text')");\n\n// Later, when outputting:\n$result = $mysqli->query("SELECT column FROM table WHERE 1");\n$row = $result->fetch_assoc();\necho htmlspecialchars($row['column'], ENT_QUOTES, 'UTF-8');