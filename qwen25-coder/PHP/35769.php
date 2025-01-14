header('Content-type: text/xml; charset=utf-8');\n\n// Set the character set for your MySQL connection\n$mysqli = new mysqli("hostname", "username", "password", "dbname");\n$mysqli->set_charset("utf8mb4");\n\n$query = "SELECT * FROM tablename";\n$result = $mysqli->query($query);\n\n$xml = new SimpleXMLElement('<root/>');\nwhile ($row = $result->fetch_assoc()) {\n    $item = $xml->addChild('element');\n    $item->addChild('key', htmlspecialchars($row['value'], ENT_QUOTES, 'UTF-8'));\n}\n\necho $xml->asXML();