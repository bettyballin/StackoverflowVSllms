$tokens = token_get_all(file_get_contents('dynamic_file.php'));\nforeach ($tokens as $token) {\n    if (is_array($token) && $token[0] == T_ERROR) {\n        // Regenerate the file\n        // ...\n        break;\n    }\n}