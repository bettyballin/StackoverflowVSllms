// Assuming you are working with $_GET data:\n$originalKeys = array_keys($_GET);\n\nforeach ($originalKeys as $key) {\n    if (strpos($key, '_') !== false) {\n        // Replace underscores back to spaces\n        $newKey = str_replace('_', ' ', $key);\n        $_GET[$newKey] = $_GET[$key];\n        \n        // Optionally unset the old key if you want to clean up\n        unset($_GET[$key]);\n    }\n}\n\n// Now you can access your variables using keys with spaces:\necho $_GET['user name']; // Outputs: Max