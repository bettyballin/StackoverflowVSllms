$zipFile = 'path/to/your/framework.zip';\n$includePath = 'zip://' . $zipFile . '#/path/to/your/framework/file.php';\n\ninclude $includePath;