$tables = array();\n$result = $db->query("SELECT table_name FROM information_schema.tables WHERE table_name LIKE 'mod_%'");\nwhile ($row = $result->fetch_assoc()) {\n    $tables[] = $row['table_name'];\n}\n\n$query = '';\nforeach ($tables as $table) {\n    $query .= "SELECT * FROM $table WHERE section_id = 'value' UNION ALL ";\n}\n\n// remove the last UNION ALL\n$query = substr($query, 0, -11);\n\n$result = $db->query($query);