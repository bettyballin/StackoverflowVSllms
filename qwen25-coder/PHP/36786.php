$stmt = $mysqli->prepare("INSERT INTO your_table_name (id, type, text, desc, pdf) VALUES (?, ?, ?, ?, ?)");\n$stmt->bind_param('issss', $values[0]['id'], $values[0]['type'], $values[0]['text'], $values[0]['desc'], $values[0]['pdf']);\n\nforeach ($values as $value) {\n    $stmt->execute();\n}\n$stmt->close();