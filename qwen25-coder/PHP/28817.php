<?php\nfunction getUserAlternatingValue() {\n    session_start(); // Start the session\n\n    // Check if the key exists in the session\n    if (!isset($_SESSION['user_alternator'])) {\n        $_SESSION['user_alternator'] = 1; // Initialize with 1 (or 0)\n    }\n\n    $currentValue = $_SESSION['user_alternator'];\n\n    // Toggle the value for the next call\n    $_SESSION['user_alternator'] = $currentValue == 1 ? 0 : 1;\n\n    return $currentValue;\n}\n\n// Example usage:\n$result = getUserAlternatingValue();\necho "User result: " . $result;\n?>