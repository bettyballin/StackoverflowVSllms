// Get the database adapter\n$db = Zend_Db_Table::getDefaultAdapter();\n\n// Define the SQL query\n$sql = "INSERT INTO sometable (column1, column2)\n        VALUES (:value1, :value2)\n        ON DUPLICATE KEY UPDATE column1 = :value1, column2 = :value2";\n\n// Bind the parameters\n$bind = array(\n    'value1' => $value1,\n    'value2' => $value2\n);\n\n// Execute the query\n$db->query($sql, $bind);