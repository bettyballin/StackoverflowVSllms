<?php\n$servername = "your_servername";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\ntry {\n    // Create a new PDO instance\n    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);\n    // Set the PDO error mode to exception\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // SQL query to select port for user_id 1 and 2\n    $query = "SELECT meta_value FROM your_table_name WHERE user_id IN (1, 2) AND meta_key = 'port'";\n\n    // Prepare the statement\n    $stmt = $conn->prepare($query);\n    \n    // Execute the statement\n    $stmt->execute();\n\n    // Fetch all results\n    $results = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\n    // Display each port number\n    foreach ($results as $row) {\n        echo "Port: " . htmlspecialchars($row['meta_value']) . "<br>";\n    }\n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}\n\n// Close the connection\n$conn = null;\n?>