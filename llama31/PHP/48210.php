$mysqli = new mysqli("localhost", "username", "password", "database");\n\n$result = $mysqli->query("SELECT QNO FROM TABLE ORDER BY RAND() LIMIT 10");\n\n$entries = array();\nwhile ($row = $result->fetch_assoc()) {\n    $entries[] = $row['QNO'];\n}\n\nprint_r($entries);