// In your main page\nif (isset($_COOKIE['Name'])) {\n    $cookie = $_COOKIE['Name'];\n    // Check if the photo has already been voted\n} else {\n    $cookie = ''; // Handle the case where the cookie is not set\n}