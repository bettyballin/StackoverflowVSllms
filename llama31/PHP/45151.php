// Generate token upon successful login\n$token = bin2hex(random_bytes(32));\n$_SESSION['token'] = $token;\n\n// Validate token on subsequent requests\nif (isset($_POST['token'])) {\n    $token = $_POST['token'];\n    if ($token === $_SESSION['token']) {\n        // Token is valid, return session data\n        echo json_encode($_SESSION);\n    } else {\n        // Token is invalid, return error\n        http_response_code(401);\n        echo json_encode(['error' => 'Invalid token']);\n    }\n}