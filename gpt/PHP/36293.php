$path = 'path/to/your/directory';\n\n// Create the directory\nif (!file_exists($path)) {\n    mkdir($path, 0777, true);\n\n    // Check if the server is running on Windows\n    if (strtoupper(substr(PHP_OS, 0, 3)) === 'WIN') {\n        // Remove the read-only attribute using exec()\n        exec("attrib -R $path");\n    }\n}