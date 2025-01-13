// profile.php\nif (!isset($_SESSION['logged_in'])) {\n    $_SESSION['redirect_url'] = $_SERVER['REQUEST_URI'];\n    header('Location: login.php');\n    exit;\n}\n\n// login.php\nif (isset($_POST['login'])) {\n    // Your login logic here\n    if ($login_success) {\n        if (isset($_SESSION['redirect_url'])) {\n            header('Location: ' . $_SESSION['redirect_url']);\n            unset($_SESSION['redirect_url']);\n        } else {\n            header('Location: index.php'); // Default redirect\n        }\n        exit;\n    }\n}