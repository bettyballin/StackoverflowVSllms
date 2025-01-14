<?php\n\n// index.php - Front Controller\n$requestUri = $_SERVER['REQUEST_URI'];\n$method = $_SERVER['REQUEST_METHOD'];\n\nswitch ($requestUri) {\n    case '/':\n        // Handle home page request\n        header('Content-Type: text/html');\n        echo "<h1>Welcome to the Home Page</h1>";\n        break;\n    case '/api/data':\n        if ($method === 'GET') {\n            // Fetch some data\n            $data = ['name' => 'Example', 'id' => 1];\n            header('Content-Type: application/json');\n            echo json_encode($data);\n        } else {\n            http_response_code(405); // Method Not Allowed\n            echo "Method not allowed";\n        }\n        break;\n    default:\n        http_response_code(404); // Not Found\n        echo "Page not found";\n}\n\n?>