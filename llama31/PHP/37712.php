// Get the JSON data from the request\n$data = json_decode(file_get_contents('php://input'), true);\n\n// Extract the data\n$tohex = $data['tohex'];\n$sum = $data['sum'];\n\n// Process the data\n$result = array(base_convert($tohex, 10, 16), array_sum($sum));\n\n// Send the response as JSON\nheader('Content-Type: application/json');\necho json_encode($result);