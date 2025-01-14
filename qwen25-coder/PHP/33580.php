<?php\n// Define the path to your secured directory\n$securedDirectory = '/path/to/secured/directory';\n\n// Assume the filename is passed as a GET parameter\nif (isset($_GET['filename'])) {\n    $filename = basename($_GET['filename']); // Use basename for security\n    $filePath = $securedDirectory . '/' . $filename;\n\n    if (file_exists($filePath)) {\n        // Determine the MIME type\n        $mimeType = mime_content_type($filePath);\n\n        // Set headers to prevent caching and specify the MIME type\n        header('Content-Type: ' . $mimeType);\n        header('Cache-Control: no-cache, no-store, must-revalidate');\n        header('Pragma: no-cache'); // Backwards compatibility with HTTP/1.0\n        header('Expires: 0');\n\n        // Read and output the file contents\n        readfile($filePath);\n    } else {\n        http_response_code(404); // File not found\n        echo "File not found.";\n    }\n} else {\n    http_response_code(400); // Bad request\n    echo "Invalid request.";\n}\n?>