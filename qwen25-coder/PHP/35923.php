<?php\n// Database connection setup goes here...\n$conn = new mysqli("localhost", "username", "password", "database");\n\nif ($conn->connect_error) {\n    die(json_encode(["success" => false, "message" => "Connection failed: " . $conn->connect_error]));\n}\n\n// Assume you have variables from the form data\n$name = $_POST['name'];\n$email = $_POST['email'];\n\n$sql = "INSERT INTO users (name, email) VALUES ('$name', '$email')";\n\nif ($conn->query($sql) === TRUE) {\n    $lastId = $conn->insert_id; // Get the last inserted ID\n    echo json_encode(["success" => true, "message" => "Record created successfully", "id" => $lastId]);\n} else {\n    echo json_encode(["success" => false, "message" => "Error: " . $sql . "<br>" . $conn->error]);\n}\n\n$conn->close();\n?>