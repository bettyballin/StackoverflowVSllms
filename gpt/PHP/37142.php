function getMimeType($filePath) {\n    // Ensure the file exists\n    if (!file_exists($filePath)) {\n        return false;\n    }\n\n    // Use the `file` command to get the MIME type\n    $output = [];\n    $returnVar = 0;\n    exec("file -b --mime-type " . escapeshellarg($filePath), $output, $returnVar);\n\n    // Check if the command was executed successfully\n    if ($returnVar !== 0) {\n        return false;\n    }\n\n    return isset($output[0]) ? trim($output[0]) : false;\n}\n\n// Example usage\n$mimeType = getMimeType('/path/to/your/file.txt');\necho 'MIME type: ' . $mimeType;