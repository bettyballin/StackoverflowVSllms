require_once 'phpzip.php';\n\n$zip = new ZipArchive();\n$zip->open('example.zip');\n$zip->extractTo('/path/to/extract');\n$zip->close();