$file = 'path/to/your/file';\n$fs = lstat($file);\necho $fs['ino'];