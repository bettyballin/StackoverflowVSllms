$uploadDirectory = "/path/to/upload/directory";\n\nif (!is_dir($uploadDirectory)) {\n    mkdir($uploadDirectory, 0700); // Set permissions to read, write, execute by owner only\n}\n\n$sourceFile = '/path/to/temp/file';\n$destinationFile = "$uploadDirectory/".basename($sourceFile);\n\nif (move_uploaded_file($sourceFile, $destinationFile)) {\n    chmod($destinationFile, 0644); // Adjust as necessary based on security requirements\n} else {\n    echo "Failed to move uploaded file.";\n}