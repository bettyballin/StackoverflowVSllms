// Start the session with a custom configuration for cookie domain\n$domain = '.example.com'; // Note the dot before example.com\nsession_set_cookie_params(0, '/', $domain);\nsession_start();\n\n// Now you can use session variables and redirect\n$_SESSION['example'] = 'value';\n\n// Redirect only if needed\n$path = $_SERVER['REQUEST_URI'];\n$currentSubdomain = explode('.', $_SERVER['HTTP_HOST'])[0];\n\nif ($currentSubdomain !== 'www') {\n    header("Location: https://www.example.com" . $path);\n    exit();\n}