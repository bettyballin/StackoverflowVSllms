<?php\n$mysqli = new mysqli("host", "user", "password", "database");\n\n// Check connection\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n// Enable warnings to be treated as errors\n$mysqli->query("SET sql_mode = 'STRICT_ALL_TABLES'");\n\n$sql = "INSERT INTO `events`(...) VALUES (...)";\nif (!$mysqli->query($sql)) {\n    echo "Error description: " . $mysqli->error;\n}\n\n// Check for warnings\n$result = $mysqli->query("SHOW WARNINGS");\nif ($result && $result->num_rows > 0) {\n    while ($row = $result->fetch_assoc()) {\n        echo "Warning: " . $row['Message'] . "\n";\n    }\n}\n$mysqli->close();\n?>