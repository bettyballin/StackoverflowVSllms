<?php\ntry {\n    $conn = odbc_connect("DSNName", "username", "password", SQL_CUR_USE_ODBC);\n    \n    if (!$conn) {\n        throw new Exception("Connection failed: " . odbc_errormsg());\n    }\n\n    // Prepare the SQL insert statement with placeholders\n    $sql = "INSERT INTO YourTableName (column1, column2) VALUES (?, ?)";\n    $stmt = odbc_prepare($conn, $sql);\n\n    // Bind parameters\n    $value1 = 'value1';\n    $value2 = 'value2';\n    $params = array($value1, $value2);\n\n    // Execute the prepared statement\n    $exec = odbc_execute($stmt, $params);\n    \n    if (!$exec) {\n        throw new Exception("Execution error: " . odbc_errormsg($conn));\n    }\n\n    echo "Success!";\n    \n    // Close the connection\n    odbc_close($conn);\n} catch (Exception $e) {\n    echo "Error: " . $e->getMessage();\n}\n?>