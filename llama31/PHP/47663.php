<?php\n// Connect to MySQL database\n$conn = new mysqli('your_host', 'your_username', 'your_password', 'your_database');\n\n// Check if username is available\n$username = $_POST['username'];\n$query = "SELECT * FROM users WHERE username = '$username'";\n$result = $conn->query($query);\n\nif ($result->num_rows == 0) {\n  echo 'available';\n} else {\n  echo 'not available';\n}\n\n$conn->close();\n?>