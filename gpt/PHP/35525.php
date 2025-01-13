<?php\n$paths = [\n    'gallery/painting/some_image_name.jpg',\n    // add more paths as needed\n];\n\nforeach ($paths as $path) {\n    // Extract the file name from the path\n    $filename = basename($path, ".jpg");\n    \n    // Replace underscores with spaces\n    $displayName = str_replace('_', ' ', $filename);\n    \n    echo '<img src="' . htmlspecialchars($path, ENT_QUOTES, 'UTF-8') . '" alt="' . htmlspecialchars($displayName, ENT_QUOTES, 'UTF-8') . '">';\n}\n?>