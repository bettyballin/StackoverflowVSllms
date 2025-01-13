$rows = array();\n$connection = mysqli_connect("hostname", "username", "password", "database");\n\nif (!$connection) {\n    die("Connection failed: " . mysqli_connect_error());\n}\n\n$res = mysqli_query($connection, $someQuery);\n\nif ($res === FALSE) {\n    // Query failed, handle the error\n    echo "MySQL error: " . mysqli_error($connection);\n} else {\n    if ($res instanceof mysqli_result && mysqli_num_rows($res) > 0) {\n        // Query was a SELECT statement with results\n        while ($row = mysqli_fetch_assoc($res)) {\n            $rows[] = $row;\n        }\n    } else {\n        // Query was a DELETE/INSERT/UPDATE statement or SELECT with no results\n        // Handle accordingly if needed\n    }\n}\n\nmysqli_close($connection);