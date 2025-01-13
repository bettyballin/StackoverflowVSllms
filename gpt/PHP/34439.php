<?php\n// Database connection parameters\n$serverName = "your_server_name";\n$connectionOptions = array(\n    "Database" => "your_database_name",\n    "UID" => "",\n    "PWD" => "",\n    "TrustServerCertificate" => true,\n    "Authentication" => SQLSRV_AUTHENTICATION_INTEGRATED,\n);\n\n// Establishes the connection\n$conn = sqlsrv_connect($serverName, $connectionOptions);\n\nif ($conn === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\n// Use the connection here\n\n// Close the connection\nsqlsrv_close($conn);\n?>