<?php\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_dbname";\n\ntry {\n    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $stmt = $conn->prepare("INSERT INTO people (id, name) VALUES (:id, :name)");\n    $stmt->bindParam(':id', $id);\n    $stmt->bindParam(':name', $name);\n\n    // Insert a row\n    $id = 1;\n    $name = "Fred";\n    $stmt->execute();\n\n    echo "New record created successfully";\n} catch(PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}\n\n$conn = null;\n?>