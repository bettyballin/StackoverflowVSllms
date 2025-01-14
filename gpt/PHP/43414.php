<?php\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// SQL to create a stored procedure\n$sql = "\nDELIMITER //\nCREATE PROCEDURE MyProcedure()\nBEGIN\n    SELECT 'Hello, World!';\nEND //\nDELIMITER ;\n";\n\n// Execute the query\nif ($conn->multi_query($sql)) {\n    echo "Stored procedure created successfully";\n} else {\n    echo "Error creating stored procedure: " . $conn->error;\n}\n\n// Close connection\n$conn->close();\n?>