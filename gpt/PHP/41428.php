<?php\n$serverName = "your_server_name";\n$connectionOptions = array(\n    "Database" => "your_database_name",\n    "Uid" => "your_username",\n    "PWD" => "your_password"\n);\n\n// Establishes the connection\n$conn = sqlsrv_connect($serverName, $connectionOptions);\n\nif ($conn === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\n// Query to list all tables\n$sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE'";\n$getTables = sqlsrv_query($conn, $sql);\n\nif ($getTables === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\nwhile ($row = sqlsrv_fetch_array($getTables, SQLSRV_FETCH_ASSOC)) {\n    $tableName = $row['TABLE_NAME'];\n    \n    // Query to get all data from the table\n    $dataQuery = "SELECT * FROM " . $tableName;\n    $getData = sqlsrv_query($conn, $dataQuery);\n    \n    if ($getData === false) {\n        die(print_r(sqlsrv_errors(), true));\n    }\n\n    $data = array();\n    while ($dataRow = sqlsrv_fetch_array($getData, SQLSRV_FETCH_ASSOC)) {\n        $data[] = $dataRow;\n    }\n\n    // Export data to JSON file\n    $jsonFileName = $tableName . ".json";\n    file_put_contents($jsonFileName, json_encode($data, JSON_PRETTY_PRINT));\n}\n\nsqlsrv_close($conn);\n?>