$stmt = $mysqli->prepare("INSERT INTO your_table_name (your_column) VALUES (?)");\n   $stmt->bind_param("s", $your_data);\n   $stmt->execute();\n   $stmt->close();