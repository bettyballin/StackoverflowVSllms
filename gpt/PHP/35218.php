<?php\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database_name";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n?>