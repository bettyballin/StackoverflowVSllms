<?php\n$host = 'p:localhost'; // Note the 'p:' prefix for persistent connection\n$username = 'username';\n$password = 'password';\n$database = 'database_name';\n\n// Persistent connection using mysqli\n$mysqli = new mysqli($host, $username, $password, $database);\n\nif ($mysqli->connect_error) {\n    die('Connect Error (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);\n}\n\n// Your query and other operations\n\n// No need to close the connection, as it is persistent\n?>