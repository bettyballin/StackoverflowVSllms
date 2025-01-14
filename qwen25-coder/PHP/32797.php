<?php\n$regionId = $_GET['region_id']; // Get the region ID from the request\n\n// Initialize Memcached\n$mc = new Memcached();\n$mc->addServer('localhost', 11211);\n\n// Try to get cached count\n$count = $mc->get("region_count_$regionId");\n\nif ($count === false) {\n    // Cache miss, perform a database query\n    $mysqli = new mysqli("localhost", "user", "password", "database");\n    \n    if ($mysqli->connect_error) {\n        die('Connect Error (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);\n    }\n\n    $stmt = $mysqli->prepare("SELECT COUNT(*) as count FROM your_table WHERE region_id = ?");\n    $stmt->bind_param("i", $regionId);\n    $stmt->execute();\n    $result = $stmt->get_result();\n    $row = $result->fetch_assoc();\n\n    $count = $row['count'];\n\n    // Store in cache for 5 minutes (300 seconds)\n    $mc->set("region_count_$regionId", $count, 300);\n}\n\necho json_encode(['count' => $count]);\n?>