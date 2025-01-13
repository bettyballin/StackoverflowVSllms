$uploaded_file = $_FILES['user_file']['tmp_name'];\n\n// Check file extension\n$extension = pathinfo($uploaded_file, PATHINFO_EXTENSION);\nif (!in_array($extension, ['png', 'jpg', 'jpeg'])) {\n    // Invalid file extension\n}\n\n// Check MIME type using finfo\n$finfo = finfo_open(FILEINFO_MIME_TYPE);\n$mime_type = finfo_file($finfo, $uploaded_file);\nfinfo_close($finfo);\nif (!in_array($mime_type, ['image/png', 'image/jpeg'])) {\n    // Invalid MIME type\n}\n\n// Check magic bytes\n$magic_bytes = file_get_contents($uploaded_file, false, null, 0, 4);\nif ($magic_bytes !== "\x89\x50\x4E\x47") {\n    // Invalid magic bytes\n}\n\n// Validate file contents (e.g., using GD for images)\n// ...\n\nif (/* all checks pass */) {\n    // File is likely a genuine image file\n} else {\n    // File is likely fake or invalid\n}