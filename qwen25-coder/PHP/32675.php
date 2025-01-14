$link = new PDO("mysql:dbname=$dbname;host=127.0.0.1", $username, $password);\n$link->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n// Validate and sanitize $day if necessary\nif (preg_match('/^[a-zA-Z0-9_]+$/', $day)) {\n    // Use the table name safely in the query string\n    $query = $link->prepare("SELECT locality_name FROM `$day` GROUP BY locality_name ORDER BY locality_name DESC");\n    $query->execute();\n    $result = $query->fetchAll();\n} else {\n    throw new Exception("Invalid table name provided.");\n}\n\n$link = null;\n// Do things with the $result.