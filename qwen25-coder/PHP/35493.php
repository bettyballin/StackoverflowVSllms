<?php\n// Read JSON input from POST request\n$inputJSON = file_get_contents('php://input');\n$data = json_decode($inputJSON, true); // Decode JSON into an associative array\n\n$tohex = $data['tohex']; // Access tohex value\n$sum = $data['sum']; // Access sum array\n\n// Calculate the results\n$result1 = base_convert($tohex, 10, 16); // Convert number to hexadecimal\n$result2 = array_sum($sum); // Sum up the numbers in the array\n\n// Return results as JSON object\nheader('Content-Type: application/json');\necho json_encode(array($result1, $result2));\n?>