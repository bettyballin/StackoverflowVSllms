<?php\n$pname = $_POST['pname'];\n\n// Database connection settings (replace with your database credentials)\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database_name";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Prepare and bind\n$stmt = $conn->prepare("SELECT name FROM your_table WHERE name = ?");\n$stmt->bind_param("s", $pname);\n\n// Execute query\n$stmt->execute();\n$result = $stmt->get_result();\n\nif ($result->num_rows > 0) {\n    echo 'success'; // Value exists\n} else {\n    echo 'failure'; // Value does not exist\n}\n\n// Close connections\n$stmt->close();\n$conn->close();\n?>