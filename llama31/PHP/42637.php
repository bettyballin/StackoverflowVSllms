// login.php\nsession_start();\nif (!empty($_POST['username']) && !empty($_POST['password'])) {\n    // Authenticate user\n    $username = $_POST['username'];\n    $password = $_POST['password'];\n    // ...\n    if ($auth_success) {\n        $_SESSION['username'] = $username;\n        $_SESSION['token'] = bin2hex(random_bytes(16));\n    }\n}