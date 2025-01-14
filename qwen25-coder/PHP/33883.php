function isValidPassword($password) {\n    $pattern = '/^([a-zA-Z0-9!@#$%^&*|()_\-+=\[\]{}:;\"\',<.>?\/~`]{4,})$/';\n    return preg_match($pattern, $password) === 1;\n}\n\n// Example usage:\n$password = "A1b#";\nif (isValidPassword($password)) {\n    echo "Password is valid.";\n} else {\n    echo "Password is invalid.";\n}