<?php\n// Binary data to be inserted (e.g., image file)\n$filePath = 'path/to/image.jpg';\n$imageData = file_get_contents($filePath);\n\n// Database connection details\n$dsn = "Driver={SQL Server};Server=your_server;Database=your_database;";\n$username = "your_username";\n$password = "your_password";\n\ntry {\n    // Connect to SQL Server using ODBC\n    $conn = new PDO($dsn, $username, $password);\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Prepare the SQL statement with a parameter for binary data\n    $sql = "INSERT INTO your_table (your_varbinary_column) VALUES (?)";\n    $stmt = $conn->prepare($sql);\n\n    // Bind the binary data to the parameter\n    $stmt->bindParam(1, $imageData, PDO::PARAM_LOB, strlen($imageData));\n\n    // Execute the statement\n    if ($stmt->execute()) {\n        echo "Binary data inserted successfully.";\n    } else {\n        echo "Error inserting binary data.";\n    }\n\n} catch (PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n}\n\n// Close the connection\n$conn = null;\n?>