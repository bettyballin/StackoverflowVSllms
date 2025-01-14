// Get the absolute path of the temporary upload file\n$absoluteFilePath = $_FILES['upfile']['tmp_name'];\n\n// Get the directory of the current script\n$currentScriptDirectory = __DIR__;\n\n// Calculate the relative path from the current script to the uploaded file's temporary location\n$relativePath = substr($absoluteFilePath, strlen(realpath($currentScriptDirectory)));\n\necho "Relative path: " . $relativePath;