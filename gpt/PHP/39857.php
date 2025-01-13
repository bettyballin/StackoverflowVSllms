<?php\nheader('Content-Type: application/json');\n\n// Database connection (use your own connection details)\n$servername = "localhost";\n$username = "root";\n$password = "";\n$dbname = "test";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die(json_encode(['message' => 'Connection failed: ' . $conn->connect_error]));\n}\n\n// Retrieve form data\n$name = $_POST['name'];\n$email = $_POST['email'];\n\n// Insert data into database\n$sql = "INSERT INTO users (name, email) VALUES (?, ?)";\n$stmt = $conn->prepare($sql);\n$stmt->bind_param("ss", $name, $email);\n\nif ($stmt->execute()) {\n    $response = [\n        'message' => 'Data successfully inserted',\n        'id' => $stmt->insert_id // Example variable to use in AJAX\n    ];\n} else {\n    $response = [\n        'message' => 'Error: ' . $stmt->error\n    ];\n}\n\n$stmt->close();\n$conn->close();\n\necho json_encode($response);\n?>