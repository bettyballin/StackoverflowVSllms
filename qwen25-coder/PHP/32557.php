<?php\n$servername = "localhost";\n$username = "westbrookc16";\n$password = "megadots";\n$dbname = "your_database_name"; // Make sure to specify your database name\n\ntry {\n    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);\n    // set the PDO error mode to exception\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n    echo "Connected successfully";\n} catch(PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n}\n?>