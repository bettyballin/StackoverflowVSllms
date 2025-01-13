function safeCopy($source, $destination) {\n    if (file_exists($destination)) {\n        throw new Exception("Destination file already exists.");\n    }\n    if (!copy($source, $destination)) {\n        throw new Exception("Failed to copy file.");\n    }\n    return true;\n}