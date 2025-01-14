<?php\n$host = "localhost";\n$user = "user";\n$password = "password";\n\n// Establish a connection\n$db_connection = new mysqli($host, $user, $password);\n\n// Check the connection\nif ($db_connection->connect_error) {\n    die("Connection failed: " . $db_connection->connect_error);\n}\n\nfunction switch_database($connection, $database_name) {\n    if (!$connection->select_db($database_name)) {\n        echo "Error selecting database: " . $connection->error;\n        return false;\n    }\n    return true;\n}\n\n// Example usage\nif (switch_database($db_connection, 'global_db')) {\n    // Run queries on global_db...\n}\n\nif (switch_database($db_connection, 'client1_db')) {\n    // Run queries on client1_db...\n}\n?>