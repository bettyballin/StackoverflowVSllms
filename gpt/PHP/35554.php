<?php\n// Establish a connection to the SQL Server\n$serverName = "serverName\\sqlexpress";\n$connectionOptions = array(\n    "Database" => "dbName",\n    "Uid" => "user",\n    "PWD" => "password"\n);\n$conn = sqlsrv_connect($serverName, $connectionOptions);\n\nif ($conn === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\n// Define the SQL query with placeholders\n$tsql = "SELECT * FROM tblUsers WHERE email = ? AND password = ?";\n\n// Define the parameters for the query\n$email = 'user@example.com'; // Replace with user input\n$encryptedPass = 'encryptedPassword'; // Replace with the encrypted password\n$params = array($email, $encryptedPass);\n\n// Prepare and execute the query\n$stmt = sqlsrv_prepare($conn, $tsql, $params);\nif ($stmt === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\n$result = sqlsrv_execute($stmt);\nif ($result === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\n// Fetch the data\nwhile ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {\n    print_r($row);\n}\n\n// Free the statement and close the connection\nsqlsrv_free_stmt($stmt);\nsqlsrv_close($conn);\n?>