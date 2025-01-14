<?php\n$serverName = "your_server_name";\n$connectionOptions = array(\n    "Database" => "your_database_name",\n    "Uid" => "your_username",\n    "PWD" => "your_password"\n);\n$conn = sqlsrv_connect($serverName, $connectionOptions);\n\nif ($conn === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\n$sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND TABLE_TYPE = 'BASE TABLE'";\n$stmt = sqlsrv_query($conn, $sql);\nif ($stmt === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\nwhile ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {\n    echo $row['TABLE_NAME'] . "\n";\n}\n\nsqlsrv_free_stmt($stmt);\nsqlsrv_close($conn);\n?>