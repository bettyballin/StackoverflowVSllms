header('Content-Type: application/json');\n\n$data = ['message' => 'Hello!'];\n\n// Simulate waiting for data\nsleep(5);\n\necho json_encode($data);