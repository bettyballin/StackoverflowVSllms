use PhpZip\ZipFile;\n\n$zipFile = new ZipFile();\n$zipFile->addFile('path/to/file.txt', 'file.txt');\n$zipFile->addDir('path/to/directory');\n$zipFile->save('example.zip');