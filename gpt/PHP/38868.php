<?php\n$serverName = "your_server_name";\n$connectionOptions = array(\n    "Database" => "your_database_name",\n    "Uid" => "your_username",\n    "PWD" => "your_password"\n);\n\n//Establishes the connection\n$conn = sqlsrv_connect($serverName, $connectionOptions);\n\nif($conn === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\necho "Connected to SQL Server successfully!";\n?>