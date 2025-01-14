function formatPlaytime($time) {\n    // Split the input time by ':'\n    $parts = explode(':', $time);\n\n    // Ensure there are two parts, if not default to 0 hours\n    $hours = isset($parts[0]) ? (int)$parts[0] : 0;\n    $minutes = isset($parts[1]) ? (int)$parts[1] : 0;\n    $seconds = isset($parts[2]) ? (int)$parts[2] : 0;\n\n    // Format the time using sprintf\n    return sprintf("%02d:%02d:%02d", $hours, $minutes, $seconds);\n}\n\n// Example usage\n$time = '1:56';\necho formatPlaytime($time); // Outputs: 00:01:56