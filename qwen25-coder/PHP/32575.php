function encodeToUtf8Xml($string) {\n    // Ensure the string is treated as UTF-8\n    $utf8String = mb_convert_encoding($string, 'UTF-8', 'auto');\n    \n    // Convert special characters to HTML entities\n    return htmlspecialchars($utf8String, ENT_XML1 | ENT_QUOTES, 'UTF-8');\n}\n\n// Example usage:\n$data = "ÖFB Stiegl Cup";\n$encodedData = encodeToUtf8Xml($data);\necho $encodedData;  // Outputs: &Ouml;FB Stiegl Cup