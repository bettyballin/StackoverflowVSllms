// Generate a unique token on the server-side\n$token = uniqid();\n\n// Store the token in the session\n$_SESSION['token'] = $token;\n\n// Pass the token to the client-side via JavaScript\necho '<script>var token = "' . $token . '";</script>';