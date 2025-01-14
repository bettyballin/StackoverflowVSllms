<?php\n$servername = "your_servername";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_dbname";\n\ntry {\n    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $sql = "INSERT INTO your_table (column1, column2) VALUES ('value1', 'value2')";\n    $conn->exec($sql);\n    \n    echo "New record created successfully. Last inserted ID is: " . $conn->lastInsertId();\n} catch(PDOException $e) {\n    echo $sql . "<br>" . $e->getMessage();\n}\n\n$conn = null;\n?>