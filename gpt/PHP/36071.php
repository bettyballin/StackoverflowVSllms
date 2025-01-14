<?php\n$host = 'your_host';\n$user = 'your_user';\n$passwd = 'your_password';\n$db = 'your_database';\n\n// Create connection\n$connect = new mysqli($host, $user, $passwd);\n\n// Check connection\nif ($connect->connect_error) {\n    die("Connection failed: " . $connect->connect_error);\n}\n\n// Check if database exists\n$db_selected = $connect->select_db($db);\n\nif (!$db_selected) {\n    // Create database if it doesn't exist\n    $create_db_sql = "CREATE DATABASE {$db}";\n    if ($connect->query($create_db_sql) === TRUE) {\n        echo "Database created successfully.";\n        // Select the newly created database\n        $connect->select_db($db);\n    } else {\n        die("Error creating database: " . $connect->error);\n    }\n} else {\n    echo "Database selected successfully.";\n}\n\n// Close the connection\n$connect->close();\n?>