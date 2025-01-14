function is_serialized($data) {\n    // If it isn't a string, it isn't serialized\n    if (!is_string($data)) {\n        return false;\n    }\n\n    // Serialized data is always at least 4 characters long\n    if (strlen($data) < 4) {\n        return false;\n    }\n\n    // Serialized data typically ends with a semicolon or a closing brace\n    if ($data[0] !== 's' && $data[0] !== 'a' && $data[0] !== 'O' && $data[0] !== 'b' && $data[0] !== 'i' && $data[0] !== 'd') {\n        return false;\n    }\n\n    // Attempt to unserialize the data\n    $result = @unserialize($data);\n\n    // If unserializing was successful, the result won't be false\n    if ($result !== false) {\n        return true;\n    }\n\n    return false;\n}\n\n// Usage\n$session_value = $_SESSION['foo'];\nif (is_serialized($session_value)) {\n    echo "The session variable is a serialized object.";\n} else {\n    echo "The session variable is not a serialized object.";\n}