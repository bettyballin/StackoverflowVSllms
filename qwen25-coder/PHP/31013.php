<?php\n\nheader("Content-Type: application/json");\n\n// Simulate database output\n$data = [\n    ["id" => 1, "name" => "John Doe"],\n    ["id" => 2, "name" => "Jane Doe"]\n];\n\n$method = $_SERVER['REQUEST_METHOD'];\n\nswitch ($method) {\n    case 'GET':\n        echo json_encode($data);\n        break;\n    default:\n        http_response_code(405); // Method Not Allowed\n        echo json_encode(["message" => "Method not allowed"]);\n}\n\n?>