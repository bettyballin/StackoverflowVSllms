function safeFunction($param) {\n    // Function logic\n    if ($someErrorCondition) {\n        return array('error' => true, 'message' => 'Error message here');\n    }\n    return array('error' => false, 'data' => $result);\n}\n\n// Usage\n$result = safeFunction($input);\nif ($result['error']) {\n    handleError($result['message']);\n} else {\n    processData($result['data']);\n}\n\nfunction handleError($errorMessage) {\n    // Log the error, show a message to user, etc.\n    echo "Error: " . $errorMessage;\n}