<?php\n// Database connection string\n$connectionString = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=your_host)(PORT=1521))(CONNECT_DATA=(SID=your_sid)))";\n\n// Connect to Oracle\n$conn = oci_connect('username', 'password', $connectionString);\n\nif (!$conn) {\n    $e = oci_error();\n    trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);\n}\n\n// Perform a query (example, select 1 from dual)\n$stid = oci_parse($conn, 'SELECT * FROM your_table');\noci_execute($stid);\n\nwhile ($row = oci_fetch_array($stid, OCI_ASSOC + OCI_RETURN_NULLS)) {\n    foreach ($row as $item) {\n        echo htmlspecialchars($item, ENT_QUOTES) . " ";\n    }\n    echo "<br>\n";\n}\n\n// Free the statement identifier when closing a connection\noci_free_statement($stid);\noci_close($conn);\n?>