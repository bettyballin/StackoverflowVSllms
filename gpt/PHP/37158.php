<?php\n$host = '127.0.0.1';\n$username = 'root';\n$password = 'password';\n$dbname = 'database';\n\n// For non-persistent connection\n$mysqli = new mysqli($host, $username, $password, $dbname);\n\n// Check connection\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\necho "Connected successfully";\n\n// Close the connection\n$mysqli->close();\n?>