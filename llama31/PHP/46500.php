$result = $db->query($sql);\n$myData = $result->fetch_assoc();\n\n// Use $myData as an array\nforeach ($myData as $key => $value) {\n    // ...\n}