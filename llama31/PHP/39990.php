$stmt = $mysqli->prepare("INSERT INTO table_name (column1, column2) VALUES (?, ?)");\n$stmt->bind_param("ss", "value1", "value2");\n$stmt->execute();\n\n$id = $stmt->insert_id;