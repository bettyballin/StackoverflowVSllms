if (!$stmt->execute()) {\n    echo "Error: " . $stmt->error;\n} else {\n    echo "Affected rows: " . $stmt->affected_rows;\n}