<?php\n$servername = "localhost";\n$username = "root";\n$password = "";\n$dbname = "your_database";\n\ntry {\n    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);\n    // set the PDO error mode to exception\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n} catch(PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n}\n?>