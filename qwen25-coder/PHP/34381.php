// Read the contents of the file\n$fileContent = file_get_contents('output.txt');\n\n// Initialize a variable to hold the unserialized data\n$data = null;\n\n// Use eval to execute the string and fill $data\neval('$data = ' . $fileContent . ';');\n\n// Now you can use $data as an array\nprint_r($data);