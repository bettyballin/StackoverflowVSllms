// Assuming $db is your Zend_Db_Adapter instance and $data is the data to be inserted\n$table = 'users';\n$data = [\n    'username' => 'example',\n    'email' => 'example@example.com'\n];\n\n// Prepare the insert SQL with RETURNING clause\n$sql = sprintf(\n    'INSERT INTO %s (%s) VALUES (%s) RETURNING userid',\n    $table,\n    implode(', ', array_keys($data)),\n    implode(', ', array_fill(0, count($data), '?'))\n);\n\n// Execute the query and fetch the returned userid\n$lastInsertId = $db->fetchOne($sql, array_values($data));\n\necho "Last inserted ID: " . $lastInsertId;