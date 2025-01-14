// Start the session at the beginning of the script\nsession_start();\n\n// process the script only if the form has been submitted\nif (array_key_exists('login', $_POST)) {\n    // Simulated login attempt, replace with actual authentication logic\n    $userAuthenticated = false; // set to true on successful authentication\n\n    if ($userAuthenticated) {\n        // Set session variables and redirect to referrer on success\n        $_SESSION['user_authenticated'] = true;\n        header('Location: ' . $_SERVER['HTTP_REFERER']);\n        exit;\n    } else {\n        // Destroy the session and store error message in session variable\n        $_SESSION = array();\n        session_destroy();\n        $_SESSION['login_error'] = "Invalid username or password"; // Set your custom error message here\n\n        header('Location: ' . $_SERVER['HTTP_REFERER']);\n        exit;\n    }\n}\n\n// On each page (inside the form block), check for login errors\nsession_start();\nif (isset($_SESSION['login_error'])) {\n    echo '<p style="color:red;">' . htmlspecialchars($_SESSION['login_error']) . '</p>';\n    unset($_SESSION['login_error']); // Clear the error message after displaying it\n}