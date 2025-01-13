<?php\n$servername = "your_servername";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_dbname";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Prepare and bind\n$stmt = $conn->prepare("INSERT INTO user_name (Name, Email) VALUES (?, ?)");\n$stmt->bind_param("ss", $name, $email);\n\n// Set parameters and execute\n$name = "Example";\n$email = "example@xyz.com";\n$stmt->execute();\n\n// Retrieve the last inserted ID\n$new_userid = $stmt->insert_id;\n\necho "New user ID: " . $new_userid;\n\n// Close statement and connection\n$stmt->close();\n$conn->close();\n?>