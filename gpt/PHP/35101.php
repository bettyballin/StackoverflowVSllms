<?php\n$zip = new ZipArchive();\n$filename = "example.zip";\n\nif ($zip->open($filename, ZipArchive::CREATE) !== TRUE) {\n    exit("Cannot open <$filename>\n");\n}\n\n$files = ['file1.txt', 'file2.txt']; // Array of files to add\n\nforeach ($files as $file) {\n    $zip->addFile($file);\n    $zip->setCompressionName($file, ZipArchive::CM_STORE); // Set compression to zero\n}\n\n$zip->close();\n\necho "Uncompressed ZIP created successfully.";\n?>