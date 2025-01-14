// Function to send command to sub-server\nfunction sendCommandToSubServer($subServerUrl, $data) {\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, $subServerUrl);\n    curl_setopt($ch, CURLOPT_POST, 1);\n    curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));\n    curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n    $response = curl_exec($ch);\n    curl_close($ch);\n\n    return $response;\n}\n\n// Example usage\n$dataToSend = ['action' => 'insert', 'table' => 'example_table', 'data' => ['column1' => 'value1']];\n$response = sendCommandToSubServer('http://subserver.com/script.php', $dataToSend);