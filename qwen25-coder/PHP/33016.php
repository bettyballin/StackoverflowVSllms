if ($result instanceof mysqli_result) {\n    // Safe to call fetch_array\n    while ($row = $result->fetch_array()) {\n        // Process each row\n    }\n} else {\n    echo "Error: Not a valid MySQLi result.";\n}