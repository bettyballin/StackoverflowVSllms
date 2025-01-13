// Define the path to the folder\n$folderPath = '/path/to/your/folder';\n\n// Check if the folder exists and is readable\nif (is_dir($folderPath) && is_readable($folderPath)) {\n    // Use scandir() to get a list of files and directories\n    $files = scandir($folderPath);\n\n    // Remove dot (.) and dot-dot (..) from the list\n    $files = array_diff($files, array('.', '..'));\n\n    // Print the list of files\n    foreach ($files as $file) {\n        echo $file . "\n";\n    }\n} else {\n    echo "Error: Folder does not exist or is not readable.";\n}