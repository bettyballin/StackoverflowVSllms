$zip = new ZipArchive();\nif ($zip->open('uncompressed.zip', ZipArchive::CREATE) === TRUE) {\n    $zip->addFile('path/to/your/file.txt', 'file.txt', 0); // Add file without compression\n    $zip->close();\n    echo 'Uncompressed ZIP created successfully.';\n} else {\n    echo 'Failed to create zip archive';\n}