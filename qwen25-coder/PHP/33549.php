// Function to sanitize inputs\nfunction sanitizeInput($input) {\n    // Strip HTML tags and whitespaces\n    return trim(strip_tags($input));\n}\n\n// Function to safely output data\nfunction safeOutput($data) {\n    // Escape HTML special characters for display\n    return htmlspecialchars($data, ENT_QUOTES, 'UTF-8');\n}\n\n// Example usage\n$rawInput = $_POST['user_input'];\n$sanitizedInput = sanitizeInput($rawInput);\n\n// Store $sanitizedInput in the database\n\n// When outputting data\necho safeOutput($retrievedDataFromDB);