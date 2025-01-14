<?php\n// log_visit.php\n\n// Get URL from query parameters\n$url = isset($_GET['url']) ? $_GET['url'] : 'http://example.com';\n\n$mysqli = new mysqli("localhost", "username", "password", "database");\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$escaped_url = $mysqli->real_escape_string($url);\n\n// Insert or update the log in the database\n$sql = "INSERT INTO url_log (url, hits) VALUES ('$escaped_url', 1) ON DUPLICATE KEY UPDATE hits = hits + 1";\n$mysqli->query($sql);\n\n$mysqli->close();\n?>