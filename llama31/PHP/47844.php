<?php\n$servername = "localhost";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\ntry {\n    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n} catch (PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n}\n?>