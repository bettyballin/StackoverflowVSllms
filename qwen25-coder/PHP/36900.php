<?php\n$subdomain = $_GET['subdomain'];\n\n// Logic to load user data based on subdomain\n$userData = getUserDataBySubdomain($subdomain);\n\nif ($userData) {\n    // Load user specific content or redirect accordingly\n} else {\n    header("HTTP/1.0 404 Not Found");\n    echo "User not found";\n    exit(404);\n}\n\nfunction getUserDataBySubdomain($subdomain) {\n    // This function should implement logic to get User data for a given subdomain\n    // Typically, this would involve querying the database.\n    return ["name" => "John Doe", "email" => "johndoe@example.com"]; // Mock Data\n}\n?>