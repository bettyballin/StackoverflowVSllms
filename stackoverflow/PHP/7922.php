$qry = $db->prepare(\n    'INSERT INTO twocents (path, name, message) VALUES (?, ?, ?)');\n$qry->execute(array($path, $name, $message));