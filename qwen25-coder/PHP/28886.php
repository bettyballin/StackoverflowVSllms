function createDir($dirName) {\n    if (empty($dirName)) {\n        return '';\n    }\n    \n    // Sanitize to prevent code injection\n    $sanitizedDirName = escapeshellarg($dirName);\n    return "mkdir -p {$sanitizedDirName}";\n}