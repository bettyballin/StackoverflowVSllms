session_start();\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    if (isset($_POST['csrf_token']) && $_POST['csrf_token'] === $_SESSION['csrf_token']) { // Validate CSRF token\n        // Sanitize inputs\n        $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);\n\n        if (!empty($name)) {\n            // Processing logic\n            $_SESSION['form_submitted'] = true;\n            echo json_encode(['success' => true]);\n        } else {\n            echo json_encode(['success' => false, 'message' => 'Name is required.']);\n        }\n    } else {\n        http_response_code(403); // Forbidden\n        echo json_encode(['success' => false, 'message' => 'CSRF token mismatch.']);\n    }\n}