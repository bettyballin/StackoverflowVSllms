<?php\nif (isset($_POST['user_id'])) {\n    $userID = intval($_POST['user_id']);\n\n    // Database connection\n    $servername = "your_server";\n    $username = "your_username";\n    $password = "your_password";\n    $dbname = "your_database";\n\n    // Create connection\n    $conn = new mysqli($servername, $username, $password, $dbname);\n\n    // Check connection\n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n\n    // Prepare and bind\n    $stmt = $conn->prepare("INSERT INTO users (user_id) VALUES (?)");\n    $stmt->bind_param("i", $userID);\n\n    // Execute the statement\n    if ($stmt->execute()) {\n        echo "Record inserted successfully";\n    } else {\n        echo "Error: " . $stmt->error;\n    }\n\n    // Close the connection\n    $stmt->close();\n    $conn->close();\n} else {\n    echo "No user ID received";\n}\n?>