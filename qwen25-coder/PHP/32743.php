function validateInput($input) {\n    // Simple validation: only allow alphanumeric characters and some punctuation\n    if (!preg_match('/^[a-zA-Z0-9,.;\-_ ]*$/', $input)) {\n        return false;\n    }\n    return true;\n}\n\nfunction safeEncodeAndStore($input, $maxLength) {\n    if (!validateInput($input)) {\n        throw new Exception("Invalid input");\n    }\n\n    // Assume we're storing in a way that requires URL encoding\n    $encodedString = filter_var($input, FILTER_SANITIZE_ENCODED);\n\n    // Check if the encoded string exceeds the maximum allowed size\n    if (strlen($encodedString) > $maxLength) {\n        throw new Exception("Encoded input exceeds maximum length");\n    }\n\n    return $encodedString;\n}\n\ntry {\n    $string = 'javascript:alert("hello!");';\n    $escaped_string = safeEncodeAndStore($string, 40);\n    echo strlen($escaped_string);\n} catch (Exception $e) {\n    echo "Error: " . $e->getMessage();\n}