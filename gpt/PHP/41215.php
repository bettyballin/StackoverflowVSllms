$serverName = "your_server_name";\n$connectionOptions = array(\n    "Database" => "your_database_name",\n    "UID" => "your_username",\n    "PWD" => "your_password"\n);\n\n// Establishes the connection\n$conn = sqlsrv_connect($serverName, $connectionOptions);\n\nif ($conn === false) {\n    die(print_r(sqlsrv_errors(), true));\n}\n\n$sql = "\nDECLARE @id bigint;\nSET @id = (SELECT MAX(application_track_id) + 1 FROM application_track_data);\nINSERT INTO application_track_data (application_track_id, user_id, action_key, action, ip_address, session_id, application) \nVALUES (@id, 1, '584', 'login', '192.168.37.60', '05sn3618p61dvmml6pkefuteg2', 'akamata');\n";\n\n// Executes the query\n$stmt = sqlsrv_query($conn, $sql);\n\nif ($stmt === false) {\n    die(print_r(sqlsrv_errors(), true));\n} else {\n    echo "Success";\n}\n\n// Closes the connection\nsqlsrv_free_stmt($stmt);\nsqlsrv_close($conn);