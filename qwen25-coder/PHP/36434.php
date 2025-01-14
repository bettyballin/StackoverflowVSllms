<?php\nheader('Content-Type: text/html; charset=utf-8');\n\n// Database connection settings\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database_name";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Set the character set to utf8mb4 (better support for special characters)\n$conn->set_charset('utf8mb4');\n\n// Example query to select data\n$sql = "SELECT * FROM your_table_name";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    // Output data of each row\n    while($row = $result->fetch_assoc()) {\n        echo htmlspecialchars($row["yourFieldName"], ENT_QUOTES, 'UTF-8') . "<br>";\n    }\n} else {\n    echo "0 results";\n}\n\n$conn->close();\n?>