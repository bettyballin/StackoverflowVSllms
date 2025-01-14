<?php\n$servername = "localhost";\n$username = "root";\n$password = "";\n$dbname = "test";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$sql = "SELECT id, Name, PANumber FROM new_users";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    // Output data of each row\n    while($row = $result->fetch_assoc()) {\n        list($firstname, $lastname) = explode(' ', $row['Name'], 2);\n        \n        // Update SQL statement\n        $updateSql = "UPDATE new_users SET firstname=?, lastname=? WHERE id=?";\n        $stmt = $conn->prepare($updateSql);\n        \n        if ($stmt === false) {\n            die("Error preparing statement: " . $conn->error);\n        }\n        \n        // Bind parameters and execute\n        $stmt->bind_param("ssi", $firstname, $lastname, $row['id']);\n        $stmt->execute();\n        \n        // Check for errors in the execution\n        if ($stmt->errno) {\n            echo "Error updating record: " . $stmt->error;\n        } else {\n            echo "Record updated successfully id=" . $row['id'] . "\n";\n        }\n        \n        // Close statement\n        $stmt->close();\n    }\n} else {\n    echo "0 results";\n}\n\n$conn->close();\n?>