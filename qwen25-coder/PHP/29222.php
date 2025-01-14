// Assume $dir is the directory path you are scanning.\n$dir = 'path/to/your/directory';\n\n// Scan the directory.\n$dir_array = scandir($dir);\n\nforeach ($dir_array as $key => $value) {\n    if ($value === '.' || $value === '..' || !is_dir($dir . '/' . $value)) {\n        unset($dir_array[$key]);\n    }\n}\n\n// Re-index the array to ensure it has sequential keys.\n$directories = array_values($dir_array);\n\nprint_r($directories);