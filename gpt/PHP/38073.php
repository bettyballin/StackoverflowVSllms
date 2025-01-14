/**\n * Outputs the specified file to the browser.\n *\n * @param string $filePath the path to the file to output\n * @param string $fileName the name of the file\n * @param string $mimeType the type of file\n */\nfunction outputFile($filePath, $fileName, $mimeType = '') {\n    // Setup MIME types\n    $mimeTypes = array(\n        'pdf' => 'application/pdf',\n        'txt' => 'text/plain',\n        'html' => 'text/html',\n        'exe' => 'application/octet-stream',\n        'zip' => 'application/zip',\n        'doc' => 'application/msword',\n        'xls' => 'application/vnd.ms-excel',\n        'ppt' => 'application/vnd.ms-powerpoint',\n        'gif' => 'image/gif',\n        'png' => 'image/png',\n        'jpeg' => 'image/jpeg',\n        'jpg' => 'image/jpeg',\n        'php' => 'text/plain'\n    );\n\n    // Set default MIME type if not provided\n    if ($mimeType == '') {\n        $fileExt = strtolower(pathinfo($filePath, PATHINFO_EXTENSION));\n        $mimeType = isset($mimeTypes[$fileExt]) ? $mimeTypes[$fileExt] : 'application/octet-stream';\n    }\n\n    // Check if file exists\n    if (!file_exists($filePath)) {\n        header("HTTP/1.0 404 Not Found");\n        exit;\n    }\n\n    // Get file size\n    $fileSize = filesize($filePath);\n\n    // Clean output buffer\n    if (ob_get_level()) {\n        ob_end_clean();\n    }\n\n    // Set headers\n    header("Content-Description: File Transfer");\n    header("Content-Type: " . $mimeType);\n    header("Content-Disposition: attachment; filename=\"" . basename($fileName) . "\"");\n    header("Content-Transfer-Encoding: binary");\n    header("Expires: 0");\n    header("Cache-Control: must-revalidate");\n    header("Pragma: public");\n    header("Content-Length: " . $fileSize);\n\n    // Read the file and output its contents\n    readfile($filePath);\n    exit;\n}