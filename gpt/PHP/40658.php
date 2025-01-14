<?php\n\nfunction tokenize($text) {\n    // Convert to lowercase\n    $text = strtolower($text);\n\n    // Remove HTML tags\n    $text = strip_tags($text);\n\n    // Replace non-alphanumeric characters with spaces\n    $text = preg_replace('/[^a-z0-9\s]/', ' ', $text);\n\n    // Tokenize the text by splitting on whitespace\n    $words = preg_split('/\s+/', $text, -1, PREG_SPLIT_NO_EMPTY);\n\n    return $words;\n}\n\nfunction indexDocument($uid, $filename) {\n    // Read the file content\n    $content = file_get_contents($filename);\n    if ($content === false) {\n        echo "Error reading file: $filename\n";\n        return;\n    }\n\n    // Tokenize the content\n    $words = tokenize($content);\n\n    // Convert the array of words to a comma-separated string\n    $wordList = implode(',', $words);\n\n    // Print the forward index entry\n    echo "$uid -> $filename -> $wordList\n";\n}\n\nfunction indexDirectory($uid, $directory) {\n    // Iterate over all files in the directory\n    $files = scandir($directory);\n    foreach ($files as $file) {\n        if ($file != '.' && $file != '..') {\n            $filePath = $directory . DIRECTORY_SEPARATOR . $file;\n            if (is_file($filePath)) {\n                indexDocument($uid, $filePath);\n            }\n        }\n    }\n}\n\n// Example usage\nindexDirectory('UID1', '/path/to/documents/domain1');\nindexDirectory('UID2', '/path/to/documents/domain2');\n\n?>