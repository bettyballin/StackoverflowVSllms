// login.php\nif (array_key_exists('login', $_POST)) {\n    // ...\n    else {\n        $_SESSION['error'] = 'Login failed';\n        header('Location: ' . $_SERVER['HTTP_REFERER']);\n        exit;\n    }\n}\n\n// details.php (or any other page)\nif (isset($_SESSION['error'])) {\n    echo $_SESSION['error'];\n    unset($_SESSION['error']);\n}