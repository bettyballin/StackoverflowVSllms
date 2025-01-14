<?php\n\n// Define a base directory to restrict access\n$base_dir = realpath('images') . '/';\n\n// Sanitize and validate the input\n$foo = filter_var($_POST["foo"], FILTER_SANITIZE_STRING);\n$bar = filter_var($_POST["bar"], FILTER_SANITIZE_STRING);\n\n// Construct the full path\n$dir_path = realpath($base_dir . $foo);\n\n// Check if the directory exists and is within the allowed base directory\nif ($dir_path && strpos($dir_path, $base_dir) === 0 && is_dir($dir_path)) {\n    $files = scandir($dir_path);\n} else {\n    // Handle invalid or unauthorized directory access\n    echo "Invalid directory";\n    exit;\n}\n\n$bar_array = explode(",", $bar);\n\nforeach ($files as $file) {\n    if ($file !== '.' && $file !== '..') {\n        echo "<img src='images/$foo/$file'>";\n    }\n}\n\n?>