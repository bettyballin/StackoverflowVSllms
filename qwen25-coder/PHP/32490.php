<?php\n// Include database connection here or require_once('database_connection.php');\n\n$email = $_POST['email'];\n\n// Prevent SQL Injection with prepared statements\n$stmt = $conn->prepare("SELECT * FROM table WHERE email = ?");\n$stmt->bind_param("s", $email);\n$stmt->execute();\n$result = $stmt->get_result();\n\nif ($result->num_rows > 0) {\n    echo "Email found!";\n} else {\n    echo "Email not found.";\n}\n\n$stmt->close();\n$conn->close();\n?>