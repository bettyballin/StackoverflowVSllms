if ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $json_data = json_decode(file_get_contents('php://input'), true);\n    if (json_last_error() !== JSON_ERROR_NONE) {\n        http_response_code(400);\n        echo 'Invalid JSON data';\n        exit;\n    }\n    $screencast = $json_data['screencast'];\n    $subject = $screencast['subject'];\n    // process the data\n    echo json_encode(['message' => 'Data received successfully']);\n} else {\n    http_response_code(405);\n    echo 'Method not allowed';\n}