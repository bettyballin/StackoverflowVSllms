<?php\n$servername = "localhost";\n$username = "your_username";\n$password = "your_password";\n$dbname = "mydatabase";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Prepare and execute the stored procedure call\n$userEmail = 'shyju@techies.com';\n$stmt = $conn->prepare('CALL tv_check_email(?)');\n$stmt->bind_param("s", $userEmail);\n\n// Execute the statement\n$stmt->execute();\n\n// Get the result\n$result = $stmt->get_result();\n\nif ($result) {\n    // Output data of each row\n    while($row = $result->fetch_assoc()) {\n        echo "USER_ID: " . $row["USER_ID"]. "<br>";\n    }\n} else {\n    echo "No results found or error in executing the procedure.";\n}\n\n// Close statement and connection\n$stmt->close();\n$conn->close();\n?>