$zip = new ZipArchive;\nif ($zip->open('test.zip', ZipArchive::CREATE) === TRUE) {\n    $zip->addFile('test.txt', 'test.txt');\n    $zip->setCompressionIndex(0, 0); // Set compression level to 0 for the first file\n    $zip->close();\n    echo 'ok';\n} else {\n    echo 'failed';\n}