$stmt = $mysqli->prepare("SELECT col1, col2, col3 FROM table WHERE col3 = ?");\n$stmt->execute();\n\n$meta = $stmt->result_metadata();\nwhile ($field = $meta->fetch_field()) {\n    $columnName = $field->name;\n    // do something with the column name\n}\n\n$stmt->close();