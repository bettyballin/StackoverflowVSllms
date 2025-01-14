<?php\n\n// Define your directories (absolute paths)\n$directories = [\n    '/path/to/first/directory',\n    '/path/to/second/directory',\n];\n\n// Set the include path for PHP to look in these directories\nset_include_path(implode(PATH_SEPARATOR, $directories));\n\n// Register an autoloader function\nspl_autoload_register(function ($className) {\n    // Normalize class name (replace namespace separators with directory separators)\n    $filePath = str_replace('\\', DIRECTORY_SEPARATOR, $className) . '.php';\n\n    // Try to include the file from each of the directories in the include path\n    foreach (explode(PATH_SEPARATOR, get_include_path()) as $dir) {\n        $fullPath = $dir . DIRECTORY_SEPARATOR . $filePath;\n        if (file_exists($fullPath)) {\n            require_once $fullPath;\n            return;\n        }\n    }\n}, true, true);\n\n// Example usage: assume you have a class named 'MyClass' in one of the folders\n$myObject = new MyClass();