<?php\nfunction getDbConnection() {\n    $host = 'localhost';\n    $dbname = 'your_database';\n    $username = 'your_username';\n    $password = 'your_password';\n\n    $conn = new mysqli($host, $username, $password, $dbname);\n\n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n\n    return $conn;\n}\n?>