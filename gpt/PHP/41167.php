// Assume we already have a database connection\n\n$query = "SELECT id \n          FROM movies \n          WHERE publish = 1\n            AND showimage = 1\n          ORDER BY date DESC\n          LIMIT 6";\n\n$result = $connection->query($query);\n\n$rows = [];\nwhile ($row = $result->fetch_assoc()) {\n    $rows[] = $row;\n}\n\n// Check if the number of results is odd\nif (count($rows) % 2 !== 0) {\n    // Remove the last row to make the result count even\n    array_pop($rows);\n}\n\n// Now you can process the even number of rows\nforeach ($rows as $row) {\n    // do some stuff\n    echo $row['id'];\n}