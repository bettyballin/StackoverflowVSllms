<?php\nif ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['sqlQuery'])) {\n    $sqlQuery = $_POST['sqlQuery'];\n\n    $serverName = "your_server_name";\n    $connectionOptions = array(\n        "Database" => "your_database_name",\n        "Uid" => "your_username",\n        "PWD" => "your_password"\n    );\n\n    // Establishes the connection\n    $conn = sqlsrv_connect($serverName, $connectionOptions);\n    if ($conn === false) {\n        die(print_r(sqlsrv_errors(), true));\n    }\n\n    // Executes the query\n    $stmt = sqlsrv_query($conn, $sqlQuery);\n    if ($stmt === false) {\n        die(print_r(sqlsrv_errors(), true));\n    }\n\n    // Fetches the results\n    $result = '<table border="1">';\n    while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {\n        $result .= '<tr>';\n        foreach ($row as $column) {\n            $result .= '<td>' . htmlspecialchars($column) . '</td>';\n        }\n        $result .= '</tr>';\n    }\n    $result .= '</table>';\n\n    echo $result;\n\n    // Closes the connection\n    sqlsrv_free_stmt($stmt);\n    sqlsrv_close($conn);\n}\n?>