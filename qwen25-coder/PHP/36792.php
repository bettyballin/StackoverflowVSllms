<?php\n// Upload process\n$uploadDirectory = '/path/to/secure/directory/uploaded_files/';\n$maxFileSize = 10 * 1024 * 1024; // 10 MB\n\nif (isset($_FILES['uploadedFile'])) {\n    $fileTmpPath = $_FILES['uploadedFile']['tmp_name'];\n    $fileName = $_FILES['uploadedFile']['name'];\n    $fileSize = $_FILES['uploadedFile']['size'];\n    $fileType = $_FILES['uploadedFile']['type'];\n\n    // Allowed file types\n    $allowedTypes = ['image/jpeg', 'image/png', 'application/pdf'];\n\n    // Use a secure method to generate new filename\n    $newFileName = uniqid() . '.' . pathinfo($fileName, PATHINFO_EXTENSION);\n\n    // Check file size\n    if ($fileSize > $maxFileSize) {\n        die('File too large.');\n    }\n\n    // Create a finfo resource\n    $finfo = finfo_open(FILEINFO_MIME_TYPE);\n    // Check the MIME type of the file from its content\n    if (false === $mimeType = finfo_file($finfo, $fileTmpPath)) {\n        die('Failed to determine file type.');\n    }\n    finfo_close($finfo);\n\n    // Validate MIME type and extension\n    if (!in_array($mimeType, $allowedTypes) || false !== strpos($newFileName, '..')) {\n        die('Invalid file type.');\n    }\n\n    // Move the uploaded file to its destination directory\n    if (move_uploaded_file($fileTmpPath, $uploadDirectory . $newFileName)) {\n        echo "File is successfully uploaded.";\n    } else {\n        die('There was an error moving the uploaded file.');\n    }\n}\n?>