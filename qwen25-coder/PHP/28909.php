// Example of simple logging\nif (!$stmt->execute()) {\n    file_put_contents('/var/log/api_errors.log', "Error inserting data: " . $stmt->error . "\n", FILE_APPEND);\n}