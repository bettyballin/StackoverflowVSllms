public function parseQS($queryString, &$postArray) {\n    // Parse the query string into an array\n    parse_str($queryString, $postArray);\n\n    // Optionally, filter input for security purposes\n    foreach ($postArray as $key => $value) {\n        $postArray[$key] = filter_var($value, FILTER_SANITIZE_STRING);\n        // Use other filters if necessary (e.g., FILTER_VALIDATE_EMAIL)\n    }\n}