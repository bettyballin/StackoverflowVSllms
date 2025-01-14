<?php\n$servername = "localhost";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\ntry {\n    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Prepare the stored procedure call\n    $stmt = $conn->prepare("CALL GetUser(:userId)");\n    \n    // Bind the parameter\n    $stmt->bindParam(':userId', $userId, PDO::PARAM_INT);\n    \n    // Set the userId value\n    $userId = 1;\n    \n    // Execute the stored procedure\n    $stmt->execute();\n    \n    // Fetch the results\n    $result = $stmt->fetchAll(PDO::FETCH_ASSOC);\n    \n    // Display the results\n    foreach ($result as $row) {\n        echo "ID: " . $row['id'] . " - Name: " . $row['name'] . "<br>";\n    }\n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}\n\n// Close the connection\n$conn = null;\n?>