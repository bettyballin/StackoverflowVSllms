<?php\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "revive_adserver";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\necho "Connected successfully";\n?>