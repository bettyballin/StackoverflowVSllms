$query = "SELECT id \n          FROM movies \n          WHERE publish = 1 \n            AND showimage = 1 \n          ORDER BY date DESC \n          LIMIT 6";\n\n$result = $connection->query($query);\n\n$rows = array();\nwhile ($row = $result->fetch_assoc()) {\n    $rows[] = $row;\n}\n\n// filter out the last row if the count is odd\nif (count($rows) % 2 != 0) {\n    array_pop($rows);\n}\n\n// now use the filtered $rows array\nforeach ($rows as $row) {\n    //do some stuff\n}