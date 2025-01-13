require_once 'Archive/Tar.php';\n\n$tar = new Archive_Tar();\n$tar->setErrorHandling(PEAR_ERROR_DIE);\n\n$files = scandir('/path/to/directory');\nforeach ($files as $file) {\n    $filePath = '/path/to/directory/' . $file;\n    if (is_file($filePath)) {\n        $tar->addFile($filePath, $file);\n    }\n}\n\n$tar->write('/path/to/output.tar');