function dbConnect() {\n    $conn = new mysqli(DB_SERVER, DB_USER, DB_PASSWORD, DB_NAME);\n    $conn->set_charset('utf8'); // Set the character set to UTF-8\n    return $conn;\n}